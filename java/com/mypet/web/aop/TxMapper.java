package com.mypet.web.aop;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.usr.User;

@Repository
public interface TxMapper {
	@Insert(" INSERT INTO USER (UID, PWD, PNAME) VALUES (" + 
			"            #{uid}, #{pwd}, #{pname})")
	public int insertUser(User u);
}
