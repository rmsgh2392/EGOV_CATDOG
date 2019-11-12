"use strict"
var adm = adm || {}
adm =(()=>{
	const WHEN_ERR = '에러'
	let _,js,css,img,adm_js,cookie_js,navi_vue_js,navi_js
	let init=()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		cookie_js = js+'/cmm/cookie.js'
		adm_js = js+'/adm/adm.js'
		navi_vue_js = js+'/vue/navi_vue.js'
		navi_js = js+'/cmm/navi.js'
		alert('adm.js 진입 ::' +adm_js)
	}
	let onCreate =()=>{
		alert('어서와 관리자는 처음이지')
		init()
		$.when(
			$.getScript(navi_vue_js)
//			$.getScript(navi_js)
		)
		.done(()=>{
			setContentView()
//			navi.onCreate()          
		})
	}
	let setContentView =()=>{
		//Dom객체
		$('body')
		.empty()
		.append(navi_vue.navi())
		$('<table id="tab"><tr></tr></table>')
		.css({border: '1px solid black', width: '80%', height: '80%', margin: '0 auto'})
		.appendTo('body')
		let arr1 = [{a:'left', b:'20%'},{a: 'right', b:'80%'}]
		$.each(arr1,(i,j)=>{
			$('<td id="'+j.a+'"></td>')
			.css({
				border: '1px solid #ddd',
				width : j.b,
				'vertical-align': 'top'})
			.appendTo('#tab tr')
		})
		let arr = [{txt :'웹크롤링',name:'web_crawling'}
				  ,{txt :'고객관리',name:'users_mgmt'}
				  ,{txt :'상품등록',name:'reg_item'}
				  ,{txt :'상품조회',name:'item_srch'}
				  ,{txt :'상품수정',name:'item_mod'}
				  ,{txt :'상품삭제',name:'item_del'}]//json인데 list
		$.each(arr,(i,j)=>{
			$('<div name="'+j.name+'">'+j.txt+'</div>')
			.css({border: '1px solid #ddd', margin: 'auto 0', 'line-height': '50px'})
			.appendTo('#left')
			.click(function(){
				let that = $(this).attr('name')//누른 녀석이 this
				$(this).addClass('active')
				$(this).siblings().removeClass('active')
				switch(that){
				case 'users_mgmt' :
					user_mgmt()
					break
				case 'reg_item' :
					break
				case 'item_srch' :
					break
				case 'item_mod' :
					break
				case 'item_del' :
					break
				case 'web_crawling' :
					webCrawling()
					break
				}
//				alert(that+'메뉴클릭 -->')
			})
		})
	}
	let user_mgmt =()=>{
		alert('고객관리 들어옴')
		$('#right').empty()
		$('<a>데이터베이스 생성</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/cmm/create/db',d=>{
				if(d.msg==='success'){
					alert('데이터베이스 생성 완료 ')}
				else {alret('데이터베이스 실패 ')}
			})
		})
		$('<a>고객테이블 생성</a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/users/create/table',d=>{
				if(d.msg==='success'){
					alert('고객테이블 생성 완료 ')}
				else {alret('고객테이블 생성 실패 ')}
			})
		})
		$('<button>고객대량정보 입력</button></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/tx/register/users',d=>{
				alert('현재까지 고객 수 :'+d.userCount)
			})
		})
		$('<button>관리자 테이블 생성</button></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/admins/create/table',d=>{
				if(d.msg==='success'){
					alert('관리자 테이블 생성 완료 ')}
				else {alret('관리자 테이블 생성 실패 ')}
			})
		})
		$('<a>고객 테이블 삭제 </a></br>')
		.appendTo('#right')
		.click(e=>{
			e.preventDefault()
			$.getJSON(_+'/users/drop/table',d=>{
				if(d.msg==='success'){
					alert('고객 테이블 제거 완료 ')}
				else {alret('고객 테이블 제거 실패 ')}
			})
		})
	}
//	let webCrawl=()=>{
//		$('#right').empty()
//		$('</br></br></br></br></br><h2>Web Crawling</h2></br></br></br></br></br></br></br>'+
//				'<form id="crawl_form" class="form-inline my-2 my-lg-0">'+
//				'  <select name="site" size="1" multiple>'+
//				'  </select>'+
//		          '<input class="form-control mr-sm-2" type="text" placeholder="insert URL for crawling" aria-label="Search">'+
//				'</form>')
//		.appendTo('#right')
//		$('#crawl_form input[class="form-control mr-sm-2"]')
//		.css({width:'80%'})
//		$.each([{sub:'naver.com'},{sub:'daum.net'},{sub:'google.com'},{sub:'youtube.com'}],(i,j)=>{
//			$('<option value='+j.sub+'>'+j.sub+'</option>').appendTo('#crawl_form select')
//		})
//		$('<button class="btn btn-secondary my-2 my-sm-0" type="submit">go crawl</button>')
//		.appendTo('#crawl_form')
//		.click(e=>{
//			e.preventDefault() 
//			let arr = [$('#crawl_form select[name="site"]').val(),
//				$('#crawl_form input[type="text"]').val()]
//			if(!$.fn.nullChecker(arr)){
//				$.getJSON(_
//						+'/tx/crawling/'+ arr[0] + '/ '+ arr[1],
//						d=>{
//					alert(d.msg)
//						})
//			}else{
//				alert('빈칸을 채우시오')
//			}
//		})
//	}	
//		$('<div class="row">'+
//		'                    <div class="col-md-3 col-sm-12 col-xs-12">'+
//		'                        <div class="panel panel-primary text-center no-boder bg-color-green">'+
//		'                            <div class="panel-left pull-left green">'+
//		'                                <i class="fa fa-bar-chart-o fa-5x"></i>'+
//		'                                '+
//		'                            </div>'+
//		'                            <div class="panel-right pull-right">'+
//		'                                <h3>8,457</h3>'+
//		'                               <strong> Daily Visits</strong>'+
//		'                            </div>'+
//		'                        </div>'+
//		'                    </div>'+
//		'                    <div class="col-md-3 col-sm-12 col-xs-12">'+
//		'                        <div class="panel panel-primary text-center no-boder bg-color-blue">'+
//		'                              <div class="panel-left pull-left blue">'+
//		'                                <i class="fa fa-shopping-cart fa-5x"></i>'+
//		'                                </div>'+
//		'                                '+
//		'                            <div class="panel-right pull-right">'+
//		'                            <h3>52,160 </h3>'+
//		'                               <strong> Sales</strong>'+
//		
//		'                          </div>'+
//		'                        </div>'+
//		'                    </div>'+
//		'                    <div class="col-md-3 col-sm-12 col-xs-12">'+
//		'                        <div class="panel panel-primary text-center no-boder bg-color-red">'+
//		'                            <div class="panel-left pull-left red">'+
//		'                                <i class="fa fa fa-comments fa-5x"></i>'+
//		'                               '+
//		'                            </div>'+
//		'                            <div class="panel-right pull-right">'+
//		'                             <h3>15,823 </h3>'+
//		'                               <strong> Comments </strong>'+
//		'                          </div>'+
//		'                        </div>'+
//		'                    </div>'+
//		'                    <div class="col-md-3 col-sm-12 col-xs-12">'+
//		'                        <div class="panel panel-primary text-center no-boder bg-color-brown">'+
//		'                            <div class="panel-left pull-left brown">'+
//		'                                <i class="fa fa-users fa-5x"></i>'+
//		'                                '+
//		'                            </div>'+
//		'                            <div class="panel-right pull-right">'+
//		'                            <h3>36,752 </h3>'+
//		'                             <strong>No. of Visits</strong>'+
//		'                           </div>'+
//		'                        </div>'+
//		'                    </div>'+
//		'                </div>').appendTo('#right')
	let webCrawling =()=>{
		alert('크롤링 들어옴')
//		$('#right').empty()
//		$('<select id="sel_url" size="1">'+
//		  '<input type="text" value="">'+
//		  '<br><input type="submit">'+
//		  '</select>')
//		  .appendTo('#right')
//		let crawl = [{ txt : 'naver', url: 'https://www.naver.com/'}
//				  ,{ txt : 'daum', url: 'https://www.daum.net/'}
//				  ,{ txt : 'google',url:'https://news.google.com/?tab=rn&hl=ko&gl=KR&ceid=KR:ko'}
//				  ,{ txt : 'youtube',url: 'http://www.baemin.com/'}]
//		$.each(crawl,(i,j)=>{
//			$('<option name="'+j.txt+'">'+j.txt+'</option>')
//			.appendTo('#sel_url')
//		})
		$('#right').empty()
		$('<h2>Crawling</h2>'+
				'<form id="crawl_form">'+
				'  <select name="web" size="1">'+
				'  </select>'+
				'   <input type="url" placeholder="insert URL" action="https://www.naver.com" value="https://www.naver.com">'+
				'</form>').appendTo('#right')
		$('#crawl_form input[type="url"]').css({width :'60%'})
		let crawl = [{value : 'naver.com' ,url : 'https://www.naver.com'},
					 {value : 'google.com' ,url : 'https://www.naver.com'},
					 {value : 'daum.com' ,url: 'https://www.naver.com'},
					 {value : 'youtube.com',url : 'https://www.naver.com'}]
		$.each(crawl,(i,j)=>{
			$('<option value="'+j.value+'">'+j.value+'</option>')
			.appendTo('#crawl_form select')
			})
//			$('<div id="result">').appendTo('#right')
			$('<input type="submit" value="전송">')
			.appendTo('#crawl_form')
			.click(e=>{
				e.preventDefault()
				if(
				!$.fn.nullChecker([$('form#crawl_form select[name="web"]').val(),
						$('form#crawl_form input[type="url"]').val()])){
				
				$.getJSON(_+'/tx/crawling/'+$('form#crawl_form select[name="web"]').val()
						   +'/'+$('form#crawl_form input[type="url"]').val(),d=>{
				//이 검색어의 주소가 어디냐 그 주소에서 데이터를 가져온다 (이미 그 주소에 존재하고 있는 데이터)
					 $('<textarea>',{
						 	text : d.text
					 }).appendTo('#right').css({width :'100%', height:'70%'})
				})
				}
		})
    }
	return{onCreate}
})()
