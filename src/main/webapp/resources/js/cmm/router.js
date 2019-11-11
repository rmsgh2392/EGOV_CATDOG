"use strict";
function Session(x){
	sessionStorage.setItem('ctx',x);
<<<<<<< HEAD
	sessionStorage.setItem('js',x+'/resources/js');
	sessionStorage.setItem('css',x+'/resources/css');
	sessionStorage.setItem('img',x+'/resources/img');
	
=======
	sessionStorage.setItem('js',x + '/resources/js')
	sessionStorage.setItem('css',x + '/resources/css')
	sessionStorage.setItem('img',x + '/resources/img')
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
	return{
		ctx : ()=>{return sessionStorage.getItem('ctx');},
		js : ()=>{return sessionStorage.getItem('js');},
		css : ()=>{return sessionStorage.getItem('css');},
<<<<<<< HEAD
		img : ()=>{return sessionStorage.getItem('img');}
	}
}

/*
 * 이것이 저번에 자바에서 했던 자바스크립트 session코드 !!
 */
=======
		img : ()=>{return sessionStorage.getItem('img');},
	}
}
//function Customer(x){
//	sessionStorage.setItem('cid', x.cid);
//	sessionStorage.setItem('pwd', x.pwd);
//	sessionStorage.setItem('ssn', x.ssn);
//	return{
//		cid : ()=>{return sessionStorage.getItem('cid');},
//		pwd : ()=>{return sessionStorage.getItem('pwd');},
//		ssn : ()=>{return sessionStorage.getItem('ssn');}
//	}
//}
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
