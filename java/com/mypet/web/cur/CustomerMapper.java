package com.mypet.web.cur;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository//메서드 이름을 테이블이름으로 주는게 좋다 
public interface CustomerMapper {
	public void insertCustomer(Customer param);
	public Customer selectCustomerById(Customer param);
	public int existId(String cid);
	public int countCustomers();
	public void createDB(HashMap<String, String> paramMap);
	public void createCustomer(HashMap<String, String> paramMap);
	public void dropCustomer(HashMap<String, String> paramMap);
	
}
