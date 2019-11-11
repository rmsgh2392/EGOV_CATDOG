package com.mypet.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.cur.Customer;
import com.mypet.web.cur.CustomerMapper;
import com.mypet.web.pxy.Proxy;


//@Transactional // 전체보다 필요한 곳에만 걸면 퍼포먼스 상승.
@Service		//서비스지만 POJO역할, 인터페이스 필요하면 람다쓰셈
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired CustomerMapper customerMapper;
	@Autowired Proxy pxy;
	//@Autowired List<String> txServicelist;
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
		txServicelist = (List<String>) pxy.crawl(paramMap);
		return txServicelist;
	}
	@Transactional
	public  int registerCustomers(){
		List<Customer> list = new ArrayList<>();
		for(Customer c : list) {
			txMapper.insertCustomer(c);
		}
		return customerMapper.countCustomers(); 
		
		}
}