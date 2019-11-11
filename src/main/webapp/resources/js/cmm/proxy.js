"use strict"
<<<<<<< HEAD
//aop에 tx 공통 !! 공통소스 --> 트랜젝션 전 팀원이 갖다 쓰는 무언가 
$.prototype.nullChecker =x=>{//x --> input박스가 여러개 배열 
	let flag = false
	let i =0
	for(i in x){
		if(x[i] === ''){
=======
//공통소스! 같이 쓰는거 만드는 사람이 리더! 어려움.  
$.prototype.nullChecker =x=>{
	let flag = false
	let i = 0
	for (i in x){
		if(x[i] ===''){
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
			flag = true
		}
	}
	return flag
}