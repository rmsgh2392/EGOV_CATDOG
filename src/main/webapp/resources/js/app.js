"use strict";
var app = app || {};
<<<<<<< HEAD
var app = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.';
	let _, js,css,img,authjs,auth_vue;//자바에 빗대어 멤버변수(인스턴스변수)이고 아래있는 run은 멤버메서드 
	let run =x=>//(x)에서 괄호를 지워도 된다.
		$.getScript(x+'/resources/js/cmm/router.js',()=>{//<--겟스크립트를 가져와 라우터제이에스가 엡제이에스에 들어오면 콜백함수 실행 
			$.extend(new Session(x));//<--$.익스텐드 부터 콜백함수 
			//session이 곧 $가 된다. $ 기능을 받는다 $가 부모 기능을 확장
			//alert('컨텍스트 : '+$.ctx())
			onCreate()
			
		})
		//이 문법이 라우터 자바스크립트에 있는 값들을 가져온다.맵핑!!
		//자바스크립트 상속 문법 실행될때 두 문법다 동시에 실행된다고 생각하면 된다.
	let init =()=>{
		_ = $.ctx()
		js = $.js()//위에 있는 인스턴스변수를 선언한것을 쓰는것이다.
		css = $.css()
		img = $.img()
		authjs = $.js()+'/cmm/auth.js'
		alert('ctx :'+_)
		//init()은 생성자라서 oncreate까지 간다.
	}
	let onCreate =()=>{
		init()
		$.when(
			$.getScript(authjs)//콜백함수가 없어서 액션은 안하고 불러오기만한다.	
		)//. . . 으로 이루어진거 메서드 체인
		.done(()=>{
			auth.onCreate()
			//콜백
		})
		.fail(()=>{
			alert(WHEN_ERR)
			//콜백
		})//when(무엇을 한다면) 성공하면done(),실패하면fail()
	}
	return{run}
	
})();

=======
app = (()=>{
	const WHEN_ERR = '호출하는 JS 파일을 찾지 못했습니다.';
	let _, js, authjs; //멤버변수, 인스턴스 변수  해당 클래스에서 공유
	let run =x=> $.getScript(x+'/resources/js/cmm/router.js',
			()=>{$.extend(new Session(x)); 
			onCreate();
	});
	let init =()=>{
		_ = $.ctx();   //메서드? 인스턴스 변수를 가져다 쓸 수 있음
		js = $.js();
		authjs = js+'/cmm/auth.js';
	}
	let onCreate=()=>{
		init();
		$.when(
			$.getScript(authjs)	
		)
		.done(()=>{
			auth.onCreate()
		})
		.fail(()=>{
			alert(WHEN_ERR)
		})//~() 할때 성공하면 done() 실패하면 fail() . . .할때마다 엔터 메소드 체인
		 
	}
	return {run};
})();





var player = (()=>{
	var _empNo,_ename,_job,_mgr,_hireDate,_sal,_comm,_deptNo;
	
	var setDeptNo = (deptNo)=>{this.deptNo = deptNo;}
	var setEmpNo = (empNo)=>{this.empNo = empNo;}
	var setEname = (ename)=>{this.ename = ename;}
	var getDeptNo = ()=>{return this._deptNo;}
	var getEmpNo = ()=>{return this. _empNo;}
	var getEname = ()=>{return this._ename;}
	return {
		setDeptNo : setDeptNo,
		setEmpNo  :  setEmpNo ,
		setEname : setEname,
		getDeptNo : getDeptNo,
		getEmpNo : getEmpNo,
		getEname : getEname
	};
})();

var employeeService = (()=>{
	return {
		login : (ctx)=>{
			$('#login_btn').click(()=>{
				if($('#username').val()===''||$('#userpw').val()===''||$('#deptname').val()===''){
					alert('필수값이 없습니다.');
				}else{
					/*alert('입력한 값 아이디'+$('#username').val());*/
					$('#login_form').attr('action',ctx+'/company.do');
					$('#login_form').attr('method','GET');
					$('#login_form').submit();
				}

			});
		},
		join: (ctx)=>{
			$('#join_btn').click(()=>{
				if($('#join_empNo').val()===''||$('#join_ename').val()===''){
					alert('필수값이 없습니다.');
				}else{
					/*alert('입력한 값 아이디'+$('#join_empNo').val());*/
					$('#join_form').attr('action',ctx+'/company.do');
					$('#join_form').attr('method','GET');
					$('#join_form').submit();
				}
			});
		},
		moveJoin : (ctx)=>{
			$('#a_join').click(()=>{
				
				location.assign(ctx+'/facade.do?page=join')
			});
		},
			
		
		search: (ctx)=>{
			$('#find2').click(()=>{
				location.assign(ctx+'/player.do?action=search&page=a_position');
			});
			
			$('#find4').click(()=>{
				location.assign(ctx+'/player.do?action=search&page=4_find_by_teamid_position');
				
			});
			
		}
		
	};
})();
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
