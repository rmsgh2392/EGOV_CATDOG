"use strict";
var auth = auth || {}//객체가 딱 하나 만들어진다 .언제? index.jsp에서 cdn방식으로 한번 만들어진다 (싱글턴 객체)!! 
auth =(()=>{
	const WHEN_ERR = '다시해봐 바보야 :)'
	let _, js, css, img, auth_vue_js, brd_js,router_js, cookie_js, adm_js
	let init =()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		auth_vue_js = js+'/vue/auth_vue.js'
		brd_js = js+'/brd/brd.js'
		router_js = js+'/cmm/router.js'
		cookie_js = js + '/cmm/cookie.js'
		adm_js = js + '/adm/adm.js'
	}
	let onCreate =()=>{
		init()
		$.when(
			$.getScript(auth_vue_js),
			$.getScript(brd_js),
			$.getScript(router_js),
			$.getScript(cookie_js),
			$.getScript(adm_js)
		)
		.done(()=>{
        	setContentView()
    		$('#a_join').click(e=>{
         		e.preventDefault()
					$('head').html(auth_vue.join_head())
					$('body').html(auth_vue.join_body())
					existId()
					$('<button>',{
							text : '회원가입' , 
							href: '#' ,
							click : e=>{		//버튼이라는 이벤트가 끝나면 실행되는 부분
				         		e.preventDefault()
				         		join()
							}
					})
					.addClass('btn btn-primary btn-lg btn-block')
					.appendTo('#btn_join')
    		})
		}) .fail(()=>{alert(WHEN_ERR)})
	}
	let setContentView =()=>{
		$('head').html(auth_vue.login_head({css : $.css(),img : $.img()}))
		$('body').addClass('text-center')
		.html(auth_vue.login_body({css : $.css(),img : $.img()}))
		login()
		access()
	}
	let join =()=>{
		let data ={
				cid : $('#cid').val(),
				pwd : $('#pwd').val(),
				pname :$('#pname').val()}
		alert('전송아이디 : '+data.cid)
	//let join =d=> d는 위에 버튼 클릭을 하면 디비를 갔다가 중복검사를 마치고 넘어온 데이터 값들(cid,pwd,pname...)
					$.ajax({
						url : _+'/customers/',
						type : 'POST',
						dataType : 'json',
						data : JSON.stringify(data),//상대방의 받는녀석의 기준이되서 타입을 맞춰준다.
						contentType : 'application/json',
						success : d => {//customerctrl에  join부분에 들어가서 실행되
							alert('회원가입 성공 :'+d.msg)
							if(d.msg==='SUCCESS'){
								$('head')
								.html(auth_vue.login_head({css : $.css(),img : $.img()}))
								$('body')
								.html(auth_vue.login_body({css : $.css(),img : $.img()}))
								.addClass('text-center')
								//로그인 그림(화면)만 보여주는 부분
								login()										//login()을 불러오면 로그인 함수의 기능들을 실행
							}else
								alert('회원가입 실패')
						},
						error : e =>{
							alert('AJAX 망함')
						}
					})//ajax부분 끝
					
				}//조인 함수 끝
	let login =()=>{
			$('<button>',{
				text : "로그인",
//				href : "#",   json은 자바스크립트 객체라서 기능을 넣어줄 수 있다.
				click : e =>{
					e.preventDefault()
					$.ajax({		//전부다 스트링값 뒤에틑 값이니까 객체도 들어오고 스트링도 들어오고 함
						url : _+'/customers/'+$('#cid').val(),
						type : 'POST',
						data : JSON.stringify({
							cid : $('#cid').val(),
							pwd : $('#pwd').val()
						}),
						dataType : 'json',
						contentType : 'application/json',//밈 -->jsp에서 contentType="text/html"내가던지는 녀석이 다른쪽에서도 
						success :  d=>{
//							$.extend(new Customer(d))
							setCookie("USERID", d.cid)
							alert('저장된 쿠키 : '+ getCookie("USERID"))
							brd.onCreate()
						},
//							alert(d.pname+'님 환영합니다.')
						error : e=>{
							alert('AJAX ERROR')
						}
					})
				}
			})
			.addClass("btn btn-lg btn-primary btn-block")
			.appendTo('#login_btn')
		}
	let existId =()=>{
		$('#cid').keyup(()=>{				//keyup이라는 이벤트가 실행되고 실행되는 부분 
			if($('#cid').val().length > 10){
				$.ajax({				//type : 'GET', GET방식은 default라 생략 가능
						url : _+'/customers/'+$('#cid').val()+'/exist',
						contentType : 'application/json',
						//ajax --> ctrl --> IFunction --> db--> ctrl-->
						//컨트롤러에서 리턴해준 값 d
						success : d => {
							//d는 갔다가 돌아오는 놈
							if(d.msg==='success')
								$('#id_check')
								.val('사용가능한 id입니다')
								.css('color','blue')
							else
							$('#id_check')
							.val('이미 있는 id입니다')
							.css('color','red')
							},
						error : e =>{
							alert('실패요')
						}//ajax와 ctrl(자바)와 통신이 안되면 오는 부분
				})//$.ajax({})부분 끝
			}//if문 끝
				
		})//keyup문 끝
	}
	let access = ()=>{
		$('#a_admin').click(()=>{
			let ok = confirm('사원쓰?') //alert의 친척. alert는 void, confirm은 boolean 리턴
			if(ok){
				let aid = prompt('사원번호ㄱㄱ')    //prompt 는 입력값을 리턴
				alert('입력한 사번 : '+ aid)
//				$.ajax({
//					url : _+'/admins/'+aid,
//					type : 'POST',
//					data : JSON.stringify({
//						aid : aid,
//						pwd : prompt('비번도 ㄱㄱ')
//					}),
//					dataType : 'json',
//					contentType : 'application/json',
//					success : d =>{
//						if(d.msg=== 'SUCCESS'){
//							alert('하이 꼬맹아')
//							adm.onCreate()
//						}else{
//							alert('접근권한 ㄴㄴ')
//							app.run(_)
//						}
//					},
//					error : e =>{
//						alert('error')
//					}
//				})
				adm.onCreate()
			}
		})
	}
	return {onCreate, join, login}    //자바스크립
})();