"use strict";
var adm = adm || {}
adm = (()=>{
	const WHEN_ERR = '다시해봐 멍충아 :)'
		let _, js, css, img, navi_vue_js;
		let init =()=>{
			_= $.ctx()
			js = $.js()
			css = $.css()
			img = $.img()
			navi_vue_js = js +'/vue/navi_vue.js'
		}
		let onCreate =()=>{
			alert('하이여!')
			init()
			$.when(
				$.getScript(navi_vue_js)
			).done(()=>{
				init()
				setContentView()
			}).fail(()=>{
				alert(WHEN_ERR)
			})
		}
		let setContentView =()=>{
		 $('body').empty()
		 $(navi_vue.navi())
		 .appendTo('body')
		 
		 $('<table id ="tab"><tr></tr></table>')
		 .css({border: '1px solid black' , width: '80%', height : '90%',' margin': '0 auto'})
		 .appendTo('body')
		 $.each([
			 		 {id : "left", width : '20%' },
			  		 {id: "right", width : '80%'}],
			  		  (i,j)=>{
			 $('<td id ="'+j.id+'"></td>')
			 .css({border: '2px solid black', width: j.width, 'vertical-align': 'top'})
			 .appendTo('#tab tr')
		 })
		 $.each([
			 {txt :'웹크롤링', name: 'web_crwal'},
			 {txt :'고객관리', name: 'cust_mgmt'},
			 {txt :'상품등록', name: 'item_reg'},
			 {txt :'상품조회', name: 'item_srch'},
			 {txt :'상품관리', name: 'item_mod'},
			 {txt :'상품삭제', name: 'item_del'}],
				(i,j)=>{
					$('<div name="'+j.name+'">'+j.txt+'</div>')
					.css({border: '2px solid black', margin: 'auto 0', 'line-height': '50px'})
					.appendTo('#left')
					.click(function(){
						//let that = $(this).attr('name')	// arrt이 t값만 있으면 getAttribute, 2개있으면 get,set
						$(this).addClass('active')
						$(this).siblings().removeClass('active')
						
						switch($(this).attr('name')){
						case 'web_crwal' :
							webCrwal()
							break;
						case 'cust_mgmt' :
							cust_mgmt()
							break;
						case 'item_reg' :
							break;
						case 'item_srch' :
							break;
						case 'item_mod' :
							break;
						case 'item_del' :
							break;
						}
			 })
		 })
	}
		let webCrwal=()=>{
			$('#right').empty()
			$('</br></br></br></br></br><h2>Web Crawling</h2></br></br></br></br></br></br></br>'+
					'<form id="crawl_form" class="form-inline my-2 my-lg-0">'+
					'  <select name="site" size="1"></select>'+
			        '<input class="form-control mr-sm-2" type="text" placeholder="insert URL for crawling" aria-label="Search">'+
					'</form>')
			.appendTo('#right')
			$('#crawl_form input[class="form-control mr-sm-2"]')
			.css({width:'80%'})
			$.each([{sub:'naver.com'},{sub:'daum.net'},{sub:'google.co.kr'},{sub:'youtube.com'}],(i,j)=>{
				$('<option value='+j.sub+'>'+j.sub+'</option>')
				.appendTo('#crawl_form select')
			})
				$('<button class="btn btn-secondary my-2 my-sm-0" type="submit">go crawl</button>')
				.appendTo('#crawl_form')
				.click(e=>{
					e.preventDefault()
					let arr = [$('#crawl_form select[name="site"]').val(),
						$('#crawl_form input[type="text"]').val()]
					if(!$.fn.nullChecker(arr)){
					$.getJSON(_+'/tx/crawling/'+arr[0]+'/'+arr[1],
							d=>{
						alert(d.msg)
					})
				}
			})
		}
		let cust_mgmt=()=>{
			$('#right').empty()
			$('<a>데이터 베이스 생성</a>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/cmm/create/db',d=>{
					alert('DB 생성 성공 여부 :' +d.msg)
				})
			})
			$('<a>고객 테이블 생성</a>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/customers/create/table',d=>{
					alert('테이블 생성 성공 여부 :' +d.msg)
				})
			})
			$('<a>고객 테이블 삭제</a>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/customers/drop/customers',d=>{
					alert('고객 수 :' +d.customerCount)
				})
			})
			$('<a>게시판 테이블 생성</a>')
			.appendTo('#right')
			.click(e=>{
				e.preventDefault()
				$.getJSON(_+'/articles/create/table',d=>{
					alert('게시판 수 :' +d.msg)
				})
			})
			}
		return {onCreate}
})()