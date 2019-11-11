package com.mypet.web.aop;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import com.mypet.web.user.User;

@Repository
public interface TxMapper {
	@Insert("insert into CUSTOMER (CID, PWD, SSN, CREDITCARD, PNAME, PHONE, ADDRESS, EMAIL) values (\r\n" + 
			"            #{cid}, #{pwd}, #{ssn}, #{creditcard}, #{pname}, #{phone}, #{address}, #{email}")
	public int insertUsers(User c);

}
