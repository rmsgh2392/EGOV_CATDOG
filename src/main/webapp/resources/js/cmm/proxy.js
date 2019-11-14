"use strict"
//aop에 tx 공통 !! 공통소스 --> 트랜젝션 전 팀원이 갖다 쓰는 무언가 
$.prototype.nullChecker =x=>{//x --> input박스가 여러개 배열 
	let flag = false
	let i =0
	for(i in x){
		if(x[i] === ''){
			flag = true
		}
	}
	return flag
}
$.prototype.checkExtension =x=>{
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$") //(exe|sh|zip|alz)이것을 업로드 할수 없게 해준다.
	let maxSize = 5242880 // 5MB
	if(x.fsize >= maxSize){
		alert('파일 사이즈 초과')
		return false
	}
	if(regex.test(x.fname)){
		alert('해당 종류의 파일은 업로드 할 수 없습니다.')
		return false
	}
	return true
}
/*function CheckExtension(x){
	let flag = false
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$")
	let maxSize = 5242880
	if(x.fsize >= maxSize){
		alert('파일 사이즈 초과')
		flag = true
		
	}
	if(regex.test(x.fname)){
		alert('해당 종류의 파일은 업로드 할 수 없습니다.')
		flag = true
		
	}
	return flag
}*/