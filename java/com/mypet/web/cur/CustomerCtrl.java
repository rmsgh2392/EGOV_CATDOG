package com.mypet.web.cur;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mypet.web.utl.Printer;
import com.mypet.web.cmm.IConsumer;
import com.mypet.web.cmm.IFunction;
import com.mypet.web.cmm.IPredicate;
import com.mypet.web.cur.Customer;
import com.mypet.web.enums.SQL;

import lombok.extern.log4j.Log4j;


@RestController
@RequestMapping("/customers")
public class CustomerCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CustomerCtrl.class);
	 //스프링컨테이너에 담아놓는다 (컨테이너와 연결)
	@Autowired Map<String, Object> map;
	@Autowired Customer customer;
	@Autowired Printer printer;
	@Autowired CustomerMapper customerMapper;
	
//	@GetMapping("/count")//자바스크립트와 먼저 xml이 먼저 송신하고 자바로 보낸다.
//search와 관련된것을 매핑함
//	public String customer(Model model) {//model녀석이 request를 감싸고 있다. 들어있음 
//		model.addAttribute("count",customerService.countCustomer());
//여기서 모델이 mapper가 된다.
//		return "index";
//	}
	@GetMapping("/{cid}/exist")
	public Map<?,?> existId(@PathVariable String cid){
		IFunction<String,Integer> p = o->customerMapper.existId(cid);
		map.clear();
		printer.accept("중복체크 :" +p.apply(cid));
		map.put("msg",(p.apply(cid)==0) ? "success" :"fail");
		return map;
	}
	
	
	@PostMapping("/")//customers데 아무것도 없으면 가져온값을 집어넣으라는 뜻 파라미터가 있으면 get없으면 post 아이디 유/무로 판단 
	public Map<?,?> join(@RequestBody Customer param) {//<?,?> ?는 와일드 카드 
//		request.getparameter("cid")를 안해도 가져올수 있다.
//		logger.info("ajax가 보낸 아이디와 비번입니다 {} ",param.getCid()+","+param.getPwd()+","+param.getPname());
//		리턴타입이 void, 이름이 번쩍하고 메퍼에다가 던져주고 없어진다.c가 있으면 이름이 있으므로 람다는 익명함수
		 printer.accept("join 들어옴");
		 IConsumer<Customer> c = t->customerMapper.insertCustomer(t);
		 c.accept(param);
		 map.clear();
		 map.put("msg","success");
		 return map;
	} 
	@PostMapping("/{cid}")// " " -> 상수 
	public Customer login(@PathVariable String cid,@RequestBody Customer param){//이제 무조건 객체로 던져야한다.rest방식 서비스임플이 람다로 다오임플이 마이바티스
		printer.accept("로그인으로 들어옴");
		IFunction<Customer,Customer> f = t-> customerMapper.selectCustomerById(t);
		printer.accept("넘어온값 :"+f.apply(param));
		return f.apply(param);
	}
	@GetMapping("/{cid}")
	public Customer searchCustomerById(@PathVariable String cid,@RequestBody Customer param) {
		IFunction<Customer,Customer> f = t-> customerMapper.selectCustomerById(param);
		return f.apply(param);
	}
	@PutMapping("/{cid}")
	public Map<?,?> UpdateCustomer(@PathVariable String cid,@RequestBody Customer param) {
		 IConsumer<Customer> c = o->customerMapper.insertCustomer(param);
		 c.accept(param);
		 map.clear();
		 map.put("msg", "SUCCESS");
		 return map;
	}
	@DeleteMapping("/{cid}")
	public Map<?,?> removeCustomer(@PathVariable String cid,@RequestBody Customer param) {
		 IConsumer<Customer> c = o->customerMapper.insertCustomer(param);
		 c.accept(param);
		 map.clear();
		 map.put("msg", "SUCCESS");
		return map;
	}
	@GetMapping("/create/table")
	public Map<?, ?> createCustomer(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_TABLE", SQL.CREATE_CUSTOMER.toString());
		 IConsumer<HashMap<String, String>> c = o->customerMapper.createCustomer(o);
		 c.accept(paramMap);
		 paramMap.clear();
		 paramMap.put("msg", "SUCCESS");
		 return paramMap;
	}
	@GetMapping("/drop/customers")
	public Map<?, ?> dropCustomer(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("DROP_TABLE", SQL.DROP_CUSTOMER.toString());
		 IConsumer<HashMap<String, String>> c = o->customerMapper.dropCustomer(o);
		 c.accept(paramMap);
		 paramMap.clear();
		 paramMap.put("msg", "SUCCESS");
		 return paramMap;
	}

}
//		1단계
//		Customer c = (Customer) (new IFunction() {
//			@Override
//			public Object apply(Object o) {
//				return customerMapper.selectById(param);
//			}
//		}).apply(param);
//		2단계
//		return (Customer) (new IFunction() {
//			@Override
//			public Object apply(Object o) {
//				return customerMapper.selectById(param);
//			}
//		}).apply(param);//3
	
//	}
	

