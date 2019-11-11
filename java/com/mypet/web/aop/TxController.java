package com.mypet.web.aop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mypet.web.pxy.ProxyMap;
import com.mypet.web.utl.Printer;

@RestController
@Transactional		//4버전은 수동설정, 5버전은 연동(default), 부트는 기본
@RequestMapping("/tx")
public class TxController {
	@Autowired Printer p;
	@Autowired TxService txService;
	@Autowired ProxyMap map;
	//@Autowired HashMap<String, String> map;
	
	@GetMapping("/crawling/{site}/{srch}")
//	public void bringUrl(@RequestBody String url) {//getjson은 리퀘스트바디 없음
	public void bringUrl(@PathVariable String site,
			@PathVariable String srch) {
		p.accept(Arrays.asList("site","srch",
				Arrays.asList(site, srch)));
		txService.crawling(map.get());
	}
	@GetMapping("/register/customers")
//	public void bringUrl(@RequestBody String url) {//getjson은 리퀘스트바디 없음
	public Map<?,?> registerCustomers() {
		int customerCount = txService.registerCustomers();
		map.accpet(Arrays.asList("customerCount"), Arrays.asList(customerCount));
		return map.get();
	}
	
}