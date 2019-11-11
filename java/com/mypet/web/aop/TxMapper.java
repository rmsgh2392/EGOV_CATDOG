package com.mypet.web.aop;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.cur.Customer;

@Repository
public interface TxMapper {
	@Insert("INSERT INTO CUSTOMER (CID,PWD,SSN,CREDITCARD,PNAME,PHONE,ADDRESS,EMAIL) values (" + 
			"            #{cid}, #{pwd},#{ssn},#{creditcard},#{pname},#{phone},#{address},#{email})")
	public int insertCustomer(Customer c);
}
