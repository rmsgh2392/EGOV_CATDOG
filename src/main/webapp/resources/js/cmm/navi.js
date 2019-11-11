"use strict"
var navi = navi || {}
navi =(()=>{
	let _,js,css,img,auth_js, auth_vue_js, brd_js, navi_vue_js, app_js
	let init =()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		app_js = js+'app.js'
		auth_js = js+'/cmm/auth.js'
		brd_js = js+'/brd/brd.js'
	}
	let onCreate =()=>{
		init()
		$.when(
			$.getScript(auth_js),
			$.getScript(brd_js))
		.done(()=>{
			setContentView()
		}).fail(()=>{alert('안됨여ㅜㅠ')})
	}
	let setContentView =()=>{
		$('<a>',{
        	href : '#',
	        text : '글쓰기'
        })
        .addClass('nav-link')
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
        	 alert('로그아웃?')
        	 deleteCookie()
        	 app.run(_)
        })
	}
	return{onCreate}
})()