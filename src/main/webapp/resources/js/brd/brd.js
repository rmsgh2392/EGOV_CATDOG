"use strict"
<<<<<<< HEAD
//sessionStorage.setItem('ctx','/web');
//sessionStorage.setItem('js','/web/resources/js');
//var _ = sessionStorage.getItem('ctx')
//var js =  sessionStorage.getItem('js')
var brd = brd || {}
brd = (()=>{
	let _,js,brd_js,brd_vuejs,router_js,navi_js,navi_vue_js,css,img,page_vue_js,cookie_js,compo_vue_js
	
	let init =()=>{
		_ = sessionStorage.getItem('ctx')
		js = $.js()
		css = $.css()
		img = $.img()
		brd_vuejs = js+'/vue/brd_vue.js'
		brd_js = js+'/brd/brd.js'
		router_js = js +'/cmm/router.js'
		navi_js = js +'/cmm/navi.js'
		navi_vue_js = js+'/vue/navi_vue.js'
		page_vue_js = js+'/vue/page_vue.js'
		cookie_js = js+'/cmm/cookie.js'
		compo_vue_js = js+'/vue/compo_vue.js'
		alert(" compo_vue_js :"+compo_vue_js)
	}
	
	let setContentView =()=>{
			$('head').html(brd_vue.brd_head({css: $.css(), img: $.img()}))
	        $('body').html(brd_vue.brd_body({css: $.css(), img: $.img()}))
	        .addClass('bg-light')
//	        .append(navi_vue.navi)
	        $(navi_vue.navi()).appendTo('#navigator')
//	        $(page_vue.pagination()).appendTo('#pagenum')
	        recent_updates({page:'1',size : '5'})
	}
	let onCreate =()=>{//액션같은거는 onCreate()에서 한다.
		init()
		$.when(
				$.getScript(brd_vuejs), 
=======
//sessionStorage.getItem('ctx')
//sessionStorage.getItem('js')
//var _ = sessionStorage.getItem('ctx',web);
//var js = sessionStorage.getItem('js',_ + '/resources/js')
var brd = brd || {};
brd = (()=>{
	let _,js,brd_vuejs, brd_js , navi_js, navi_vue_js, page_vue_js , compo_vue_js

	let init=()=>{
		_ = sessionStorage.getItem('ctx')
		js = $.js()
		brd_js = js+'/brd/brd.js'
		brd_vuejs = js+'/vue/brd_vue.js'
		navi_js = js+'/cmm/navi.js'
		navi_vue_js = js+'/vue/navi_vue.js'
		page_vue_js = js+'/vue/page_vue.js'
		compo_vue_js = js + '/vue/compo_vue.js/'
		alert('page_vue'+page_vue)
	}
	let onCreate=()=>{                 //동적인거 여기에다 다 넣음?
		init()
		$.when(
				$.getScript(brd_vuejs),
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
				$.getScript(navi_js),
				$.getScript(navi_vue_js),
				$.getScript(page_vue_js),
				$.getScript(compo_vue_js)
<<<<<<< HEAD
		)
		.done(()=>{
			setContentView()
			navi.onCreate()
		}).fail(()=>{
			alert('navi실패')
		})
	}
	
	let recent_updates =x=>{
			alert('호출된 페이지 번호 :'+x.page)
		  $('#recent_updates .media').remove()
		  $('#suggestions').remove()
	      $('#recent_updates .d-block').remove()
	      $('#recent_updates .container').remove()
	      $.getJSON(_+'/articles/page/'+x.page+'/size/'+x.size,d=>{
	      //url는 명사로 해야함! count는 데이터베이스에 저장되지 않는 상태 데이터 글이 계속 추가하거나 제거할수록 시시각각 데이터의 상태가 바뀌니까 
	  			$.each(d.articles, (i,j)=>{//i는 인덱스 값 j가 우리가 하고싶은 article value ,get(i)
	  					$('<div class="media text-muted pt-3">'+
	  					'<img data-src="holder.js/32x32?theme=thumb&amp;bg=007bff&amp;fg=007bff&amp;size=1" alt="32x32" class="mr-2 rounded" style="width: 32px; height: 32px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2232%22%20height%3D%2232%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2032%2032%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16dfcdddb72%20text%20%7B%20fill%3A%23007bff%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A2pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16dfcdddb72%22%3E%3Crect%20width%3D%2232%22%20height%3D%2232%22%20fill%3D%22%23007bff%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2211.5390625%22%20y%3D%2216.9%22%3E32x32%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">'+
	  					'<p id="id_'+i+'" class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">'+
	  					'</p></div>').appendTo('#recent_updates')
	  			$('<strong class="d-block text-gray-dark">@<a>'+j.uid+'</a></strong>')
	  			.appendTo('#id_'+i)
	  			.click(()=>{
	  				alert('id클릭')
	  			})
	  			$('<a>'+j.title+'</a>')
	  			.appendTo('#id_'+i)
	  			.click(()=>{
	  				alert('제목 클릭')
	  				detail(j)
	  				
	  			})
                //alert("i는"+i)
	  			//태그 안에 들어가면 value 밖에들어가는값은 text
	  			})
	  			$(page_vue.pagination()).appendTo('#recent_updates').css({'pading-left':'30%'})
	  			$('#pagenum').empty()
	  			$(compo_vue.page_size()).prependTo('div.container')
	  			$.each([
	  				    {txt :'5개씩',val : '5'},
	  				    {txt :'10개씩',val : '10'},
	  				    {txt : '15개씩',val : '15'},
	  				    {txt :'20개씩',val : '20'}],(i,j)=>{
	  				$('<option value="'+j.val+'">'+j.txt+'</option>')
	  				.appendTo('#listSizeSelectDiv select')
	  			})
	  			$('#listSizeSelectDiv select option[value="'+d.proxy.pageSize+'"]').attr('selected',true)
	  			$('#listSizeSelectDiv select').change(()=>{
	  				alert('선택보기 :'+$('#listSizeSelectDiv select').val())
	  				recent_updates({page : '1', size : $('#listSizeSelectDiv select').val()})
	  			})
	  			if(d.proxy.existPrev){
	  			alert(d.proxy.existPrev)
	  			$('<li class="page-item"><a class="page-link" href="#">이전</a></li>')
	  			.prependTo('#pagenum')
	  			.click(()=>{
	  				recent_updates({page : d.proxy.prevBlock ,size:d.proxy.pageSize})//재귀호출
	  			})
	  			}
	  			let i = 0
	  			
	  			for(i=d.proxy.startPage; i<d.proxy.endPage+1; i++) {
	  				if(d.proxy.pageNum == i){
	  					$('<li class="page-item"><a class="page-link" href="#">'+i+'</a></li>')
		  				.appendTo('#pagenum')
		  				.addClass('active')
	  				}else{
	  					$('<li class="page-item"><a class="page-link" href="#">'+i+'</a></li>')
		  				.appendTo('#pagenum')
		  				.click(function(){//호이스팅 떄문에 펑션을 쓰면 상수풀에 들어간다
		  					alert('페이지 번호 >>>' +$(this).children('.page-link').text())
		  					recent_updates({page:$(this).children('.page-link').text() , size : d.proxy.pageSize})
		  					//시발 어렵다
		  				})
	  				}
	  			}
	  			/*$.each(d.proxy.pages,(i,j)=>{
	  				$('<li class="page-item"><a class="page-link" href="#">'+j+'</a></li>')
	  				.appendTo('#pagenum')
	  				.click(()=>{
	  					alert('클릭'+j)
	  					recent_updates({page:j , size : d.proxy.pageSize})//재귀호출
	  				})
	  			})*/
	  			if(d.proxy.existNext){
	  			alert(d.proxy.existNext)
	  			$('<li class="page-item"><a class="page-link" href="#">다음</a></li>')
	  			.appendTo('#pagenum')
	  			.click(()=>{
	  				alert('다음클릭')
	  				recent_updates({page : d.proxy.nextBlock , size : d.proxy.pageSize}) //재귀호출
	  			})
	  			}
	  			$('#listSizeSelectDiv').css({float : 'right'})
	      })
	}
	      
	

	  			
	  	     //여기까지 each세상 이치세상은 아래 리센트 세상을 모른다.,$.()객체들은 독립적으로 움직이는 세상 
	  		//res는 이제 상태변화가 없다.상태가 다하고 나옴
	       //서플라이에 해당하는거 파라미터없이 값만 가지고 옴
	      //있는 값을 가지고 오기때문에 에러가 나지 않는다 (로그인처럼 아이디 중복이나 아이디가 틀리지 않으니까)
	let write =()=>{
		alert('ctx : '+_   +','+' brd_vue.js :'+ brd_vuejs)
		$('#recent_updates').html(brd_vue.brd_write())
		$('#write_form input[name="writer"]').val(getCookie("uid"))
		$('#suggestions').remove()
		$('<input>',{
			style : 'float:right;width:100px;margin-right:10px',
			value : '취소',
		})
		.addClass('btn btn-danger')
		.appendTo('#write_form')
		.click(()=>{
			alert('취소취소')
			setContentView()
		})
		$('<input>',{
			style : 'float:right;width:100px;margin-right:10px',
			value : '전송',
			type : 'submit',
		
		})
		.addClass('btn btn-primary')
		.appendTo('#write_form')
		.click  (e=>{
			e.preventDefault()
			let json = {
				cid :  $('#write_form input[name="writer"]').val(),
				title : $('#write_form input[name="title"]').val(),
				content : $('#write_form textarea[name="content"]').val()
			}
			alert('title : '+json.title)
			$.ajax({
				url :sessionStorage.getItem('ctx')+'/articles/',
				type : 'POST',
				//1.rest프레임 타입 중 상태에 대한 타입 (post,get,put,delete) crud!!
				data : JSON.stringify(json),
				dataType : 'json',
				//2.json타입 자바스크립트는 객체 타입은 전부 json!!{} 객체구나 [] 컬렉션이구나 어쩃든 타입은 json !!! ,가기전
 				contentType : 'application/json',
 				//3.자바가 보낸것을 이렇게 바꿔라 원래는 application(자바,c파이썬)어떤건지 모르지만 json으로 바꿔라 ,갔다왔을때 타입 
				success : d=>{//goodbye adios
					alert('ajax결과 :'+d.msg)
					$('#recent_updates div.container-fluid').remove()
					recent_updates({page: '1', size: '5'})
				},
				error : e=>{
					alert('에러발생 심각심각')
				}
			})
		})
		
	}

	
//	<input type="reset" class="btn btn-danger" style="float:right;width:100px;margin-right:10px" value="CANCEL"/>'
//	+'<input id="write_btn" name="write" type="submit" class="btn btn-primary" style="float:right;width:100px;margin-right:10px" value="SUBMIT"/>'
	
	let detail =x=>{
		//글의 시퀀스 넘버를 주면 쿼리를 이용해 뽑아내자
		alert('넘기는 seq값'+x)
		$('#recent_updates').html(brd_vue.brd_write())
		$('#recent_updates div.container-fluid h1 ').html('ARTICLE DETAL')
		alert('사용자 아이디 ::'+x.cid)
		$('#write_form input[name="writer"]').val(x.uid)
		$('#write_form input[name="title"]').val(x.title)
		$('#write_form textarea[name="content"]').val(x.content)
		$('#suggestions').remove()
		$('<input>',{
			style : 'float:right;width:100px;margin-right:10px',
			value : '삭제',
		})
		.addClass('btn btn-danger')
		.appendTo('#write_form')
		.click(()=>{
			e.preventDefault()
			alert('취소취소')
          	deleteArticle(x)
		})
		$('<input>',{
			style : 'float:right;width:100px;margin-right:10px',
			value : '수정',
			type : 'submit',
		
		})
		.addClass('btn btn-primary')
		.appendTo('#write_form')
		.click (e=>{
			e.preventDefault()
			alert('수정하쉴')
			updateArticle(x)
		})
		
	}
	let  deleteArticle=x=>{
		alert('넘어온 파라미터 x값'+x)
		$.ajax({
			url : _+'/articles/'+x.articleseq,
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(x),
			contentType: 'application/json',
			success : d=>{
				if(d.msg==='success')
				alert('삭제 성공')
				$('#recent_updates div.container-fluid').remove()
				recent_updates()
			},
			error : e=>{
				alert('삭제 실패')
			}
			
		})
		
	}
	let updateArticle =x=>{
		alert('넘어온 x값 ::'+x)
		$.ajax({
			url : _+'/articles/'+x.articleseq,
			type : 'PUT',
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify({
				articleseq : x.articleseq,
			    cid :$('#write_form input[name="writer"]').val() ,
				title : $('#write_form input[name="title"]').val(),
				content :$('#write_form textarea[name="content"]').val() 
			}),
			success : d=>{
				alert('에이작스 성공')
				
//				$('#recent_updates').html(brd_vue.brd_write())
//				$('#write_form input[name="writer"]').val($cid)
//				$('#suggestions').remove()
//				write()
				$('#recent_updates div.container-fluid').remove()
				recent_updates()
			},
			error : e=>{
				alert('수정실패')
			}
			
		})
		
	}
	
	
	return{onCreate, write}
	
	
=======
				).done(()=>{
					setContentView()
					navi.onCreate()
				}).fail(()=>{
					alert(WHEN_ERR)
		})
	}
	let setContentView=()=>{
			$('head').html(brd_vue.brd_head({css: $.css(), img: $.img()}))
			$('body').addClass('text-center').html(brd_vue.brd_body({css: $.css(), img: $.img()}))

			$(navi_vue.nav()).appendTo('#navi')
			recent_updates({page:'1',size:'5'})
			
	}
	let recent_updates=x=>{                        //x가 d.count
		$('#recent_updates .media').remove()
		$('#suggestions').remove()
		$('#recent_updates .d-block').remove()
		$('#recent_updates .container').remove()
		$.getJSON(sessionStorage.getItem('ctx')+'/articles/page/'+x.page+'/size/'+x.size,d=>{
			let pxy = d.pxy
			alert('길이'+Object.keys(d).length)
			$.each(d.articles,(i,j)=>{
				$( '<div class="media text-muted pt-3">'+
						'<img data-src="holder.js/32x32?theme=thumb&amp;bg=007bff&amp;fg=007bff&amp;size=1" alt="32x32" class="mr-2 rounded" style="width: 32px; height: 32px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2232%22%20height%3D%2232%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2032%2032%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16dfcdddb72%20text%20%7B%20fill%3A%23007bff%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A2pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16dfcdddb72%22%3E%3Crect%20width%3D%2232%22%20height%3D%2232%22%20fill%3D%22%23007bff%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2211.5390625%22%20y%3D%2216.9%22%3E32x32%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">'+
						'          <p id="id_'+i+'"class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">'+
						'          </p></div>').appendTo('#recent_updates')
				$('<strong class="d-block text-gray-dark">@<a>'+j.cid+'</a></strong>')
				.appendTo("#id_"+i)
				.click(()=>{
					alert('id클릭')	
				})
				$('<a>'+j.title+'</a>')
				.appendTo("#id_"+i)
				.click(()=>{
					alert('제목클릭')
					detail(j)
					
				})
				
//				
//				res += '<div class="media text-muted pt-3">'+
//				'<img data-src="holder.js/32x32?theme=thumb&amp;bg=007bff&amp;fg=007bff&amp;size=1" alt="32x32" class="mr-2 rounded" style="width: 32px; height: 32px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2232%22%20height%3D%2232%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2032%2032%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16dfcdddb72%20text%20%7B%20fill%3A%23007bff%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A2pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16dfcdddb72%22%3E%3Crect%20width%3D%2232%22%20height%3D%2232%22%20fill%3D%22%23007bff%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2211.5390625%22%20y%3D%2216.9%22%3E32x32%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">'+
//				'          <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">'+
//				'            <strong class="d-block text-gray-dark">@</strong>'+
//				'          </p>'+
//				'        </div>'
			})
			$(page_vue.pagination()).appendTo('#recent_updates')

			
			
//			$('#crawl_form input[class="form-control mr-sm-2"]')
//			.css({width:'80%'})
//			$.each([{sub:'naver.com'},{sub:'daum.net'},{sub:'google.co.kr'},{sub:'youtube.com'}],(i,j)=>{
//			$('<option value='+j.sub+'>'+j.sub+'</option>').appendTo('#recent_updates')
//			})
//			$('#pNum').html(compo_vue.pageSize())
//			$(compo_vue.pageSize()).appendTo('#recent_updates')
//			$(compo_vue.pageSiez2()).appendTo('#recent_updates')
		
			
			$('#paginagtion').empty()
			$('#recent_updates div.container h2').remove() 
			$('<form id="paging_form" class="form-inline my-2 my-lg-0" style="float: right">'+
				'  <select name="site" size="1">'+
				'  </select>'+
				'</form>').prependTo('#recent_updates div.container')
			$('#paging_form input[class="form-control mr-sm-2"]').css({width:'80%'})
			
			$.each([
				{sub:'5개보기',val:'5'},
				{sub:'10개보기',val:'10'},
				{sub:'15개보기',val:'15'},
				{sub:'20개 보기',val:'20'}],
				(i,j)=>{$('<option value='+j.val+'>'+j.sub+'</option>').appendTo('#paging_form select')
			})
			$('#paging_form option[value="'+pxy.pageSize+'"]').attr('selected',true)
			$('#paging_form').change(()=>{
				alert('선택한 보기: '+$('#paging_form option:selected').val())
				recent_updates({page: '1', size: $('#paging_form option:selected').val()})
			})
			
//			let t =''
//			let i = 0
//			for(;i<(d.length)/10;i++){
//				t += '<li class="page-item"><a class="page-link" href="#">'+(i+1)+'</a>'
//			}
//			$(t).appendTo('#paginagtion')
			
			
			if(pxy.existPrev){
				$('<li class="page-item"><a class="page-link" href="#">이전</a></li>')
				.appendTo('#paginagtion')
				.click(()=>{
					recent_updates({page:pxy.prevBlock,size:pxy.pageSize})
				})
			}
			
			let i = 0
			for(i = pxy.startPage; i<= pxy.endPage ; i++) {
				if(pxy.pageNum == i){
					$('<li class="page-item"><a class="page-link" href="#">'+i+'</a></li>')
					.appendTo('#paginagtion')
					.addClass('active')
				}else{
					$('<li class="page-item"><a class="page-link" href="#">'+i+'</a></li>')
					.appendTo('#paginagtion')
					.click(function(){
						alert('페이지번호>>>:'+$(this).children('.page-link').text())
						recent_updates({page:$(this).children('.page-link').text(), size: pxy.pageSize})
					})
				}
			}
			
//			$.each(pxy.pages,(i,j)=>{
//				$('<li class="page-item"><a class="page-link" href="#">'+j+'</a></li>')
//				.appendTo('#paginagtion')
//				.click(()=>{
//					recent_updates({page:j,size:'5'})				
//				})
//			})

			
			if(pxy.existNext){
      			$('<li class="page-item"><a class="page-link" href="#">다음</a></li>')
      			.appendTo('#paginagtion')
      			.click(e=>{
      				e.preventDefault()
					recent_updates({page:pxy.nextBlock,size:pxy.pageSize})
				})
      		}
			 // paginagtion,   paginagtion
			
			
			
			//i가 인덱스 j 가 벨류인데 이게 아티클! ui 가 들어가야함
//				for(let i=0;i<d.count;i++){res += ui}
//			$('<a>',{
//				text:j.title
//			}).appendTo('div.media p')
//			.click(()=>{
//				alert('제목클릭')
//			})
//			$('<a>',{
//				text:j.cid
//			}).appendTo('div.media p strong')
//			.click(()=>{
//				alert('아이디클릭')
//			})
//			$('#recent_updates').append(res)
		})  
	}
	
	let write=()=>{
		$('#recent_updates').html(brd_vue.brd_write())
//		alert('사용자 아이디'+cid)
		$('#write_form input[name="writer"]').val(getCookie("cid"))
		$('#suggestions').remove()
		$('<input>',{
			style:'float:right;width:100px;margin-right:10px',
			value:'전송'	
		})
		.addClass('btn btn-primary')
		.appendTo('#write_form')
		.click(e=>{
			e.preventDefault();
			let json = {
					cid:$('#write_form input[name="writer"]').val(),
					title:$('#write_form input[name="title"]').val(),
					content:$('#write_form textarea').val()
			}
			alert('id'+json.cid+'글제목'+json.title+'글내용'+json.content)
			alert('-?'+_)
			$.ajax({		//ajax 는 무조건 리턴이 있어야함!! 파라미터가 있는 녀석과 없는 녀석, 람다함수는 fuction. supply
				url: sessionStorage.getItem('ctx')+'/articles/',
				type:'POST',
				data:JSON.stringify(json),
				dataType:'json',
				contentType:'application/json',
				success:d=>{
					$('#recent_updates div.container-fluid').remove()
					alert('글쓰기 성공')
					recent_updates({page:'1',size:'5'})
//					$.getScript(brd_vuejs).done(()=>{
//                        $('#recent_updates').html('<h1>목록 불러오기</h1>')
//                    })
				},
				error:d=>{
					alert('ajax 실패')
				}
			})
			
		})
		$('<input>',{
			style:'float:right;width:100px;margin-right:10px',
			type:'submit',
			value:'취소'	
		})
		.addClass('btn btn-danger')
		.appendTo('#write_form')
		.click(()=>{
			recent_updates({page:'1',size:'5'})
		})
	}

//		$('<a>',{
//			href:'#',
//			click:e=>{
//				e.preventDefault();
//				write()
//			},
//			text:'글쓰기'
//		})  
//		.css('color','white')
//		.addClass('nav-link')
//		.appendTo('#go_write')	
	
	let detail = x =>{
		$('#recent_updates').html(brd_vue.brd_write())
		$('#recent_updates div.container-fluid h1').html("아티클 디테일")
		$('#write_form input[name="writer"]').val(x.cid)
		$('#write_form input[name="title"]').val(x.title)
		$('#write_form input[name="content"]').val(x.content)
		$('#suggestions').remove()
		$('<input>',{
			style:'float:right;width:100px;margin-right:10px',
			value:'삭제'	
		})
		.addClass('btn btn-primary')
		.appendTo('#write_form')
		.click(e=>{
				e.preventDefault()
				$.ajax({
				url : _+'/articles/'+x.articleseq,
				type : 'DELETE',
				dataType : 'json',
				data : JSON.stringify(x),
				contentType:'application/json',
				success:d=>{
					alert('삭제 성공')
				    write()
					$('#recent_updates div.container-fluid').remove()
					recent_updates({page:'1',size:'5'})
				},
				error:d=>{
					alert('ajax 삭제 실패')
				}
			})
			
		})
		$('<input>',{
			style:'float:right;width:100px;margin-right:10px',
			type:'submit',
			value:'수정'	
		})
		.addClass('btn btn-danger')
		.appendTo('#write_form')
		.click(e=>{		
			e.preventDefault()
	 		alert('수정 시작')
	 		let json = { 
				articleseq :  $('#write_form input[name="brdseq"]').val() ,
				content : $('#write_form textarea[name="content"]').val()
			}     	
			$.ajax({
				url : _+'/articles/'+x.articleseq,
				type : 'PUT',
				dataType : 'json',
				contentType : 'application/json',
				data : JSON.stringify({
					articleseq : x.articleseq,
				    cid :$('#write_form input[name="writer"]').val() ,
					title : $('#write_form input[name="title"]').val(),
					content :$('#write_form textarea[name="content"]').val() 
				}),
//				url : _+'/articles/'+x.articleseq, 
//				type : 'PUT',
//				dataType : 'json',
//				data: JSON.stringify(json) , 
//				contentType : 'application/json',
				success : d =>{
					alert('수정성공');
					write()
					$('#recent_updates div.container-fluid').remove()
					recent_updates({page:'1',size:'5'})
				},
				error : e =>{
					alert('게시수정성공 실패');
				}
			})      	
		})
	}
	
	return {onCreate,write}  //나가는게 public !! 다른곳에서 끌고올때 퍼블릭 상태로 해줘야함!
		
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
})();