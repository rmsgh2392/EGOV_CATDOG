"use strict"
var navi = navi || {}
<<<<<<< HEAD
navi =(()=>{
	let _,js,css,img,navi_js,brd_js,router_js,navi_vue_js,auth_js,app_js
	let init =x=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		router_js = js+'/cmm/router.js'
		navi_js = js+'/cmm/navi.js'
		auth_js = js+'/cmm/auth.js'
		brd_js = js+'/brd/brd.js'
		navi_vue_js = js+'/vue/navi_vue.js'
		app_js = js+'app.js'
		alert('navi init들어옴')
	}
	
	let setContentView =()=>{
//		$('nav').html(navi_vue.navigation_navi()).addClass('navbar').appendTo('#navi')
=======
navi = (()=>{
	let _,js,brd_vuejs, brd_js, navi_vuejs, auth_js, app_js
	let init=()=>{
		_ = $.ctx()
		js = $.js()
		app_js = js+'app.js'
		brd_js = js+'/brd/brd.js'
		brd_vuejs = js+'/vue/brd_vue.js'
		navi_vuejs = js+'/vue/navi_vue.js'
		auth_js = js+'/cmm/auth.js'

	}
	let onCreate=()=>{
		init()
		$.when(
			$.getScript(auth_js),
			$.getScript(brd_js)
		).done(()=>{
			setContentView()
		}).fail(()=>{
			alert(WHEN_ERR)
		})
		
	}
	let setContentView =()=> {
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
		$('<a>',{
        	href : '#',
	        text : '글쓰기'
        })
        .addClass('nav-link')
<<<<<<< HEAD
        .appendTo('#menu_text')
        .click(e=>{
        	 e.preventDefault()
        	 brd.write({cid :  $('#write_form input[name="writer"]').val(),
				title : $('#write_form input[name="title"]').val(),
				content : $('#write_form textarea[name="content"]').val()})
        })
        $('<a>',{
			href : '#',
			text : '로그아웃'
		})
		.addClass('nav-link')
		.appendTo('#menu_logout')
		.click(e=>{
        	 e.preventDefault()
        	 alert('로그아웃하실 ㅁ')
        	 deleteCookie()
//        	 auth.onCreate()
        	 app.run(_)
        })
	}
	let onCreate =()=>{
		init()
		$.when(
			$.getScript(auth_js),
			$.getScript(brd_js))
		.done(()=>{
			setContentView()
		})
		.fail(()=>{
			alert('안됨')
		})
	}
	
	return{onCreate}
	
	
})();
=======
        .appendTo('#menu_write')
        .click(e=>{
        	e.preventDefault()
        	brd.write()

        })
        $('<a>',{
        	href : '#',
	        text : '로그아웃'
        })
        .addClass('nav-link')
        .appendTo('#menu_logout')
        .click(e=>{
        	e.preventDefault()
        	alert('로그아웃 클릭시')
        	deleteCookie()
        	app.run(_)
        })
	}

	return {onCreate}
})()
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
