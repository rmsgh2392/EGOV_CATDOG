package com.mypet.web.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.pxy.Proxy;
import com.mypet.web.user.User;
import com.mypet.web.user.UserMapper;


@Service
public class TxService {
	@Autowired TxMapper txmapper;
	@Autowired Proxy pxy;
	@Autowired UserMapper customerMapper;
//	@Autowired List<String> txServicelist;
	
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
		txServicelist = (List<String>) pxy.crwal(paramMap);
		return txServicelist;
	}


	@Transactional   //쿼리문 중복실행되는 곳에만 이렇게 어노테이션 걸어라!
	public int registerUsers() {
		List<User> list = new ArrayList<>();
		for(User c:list) {
			txmapper.insertUsers(c);
		}
		
		return customerMapper.countUsers();
	}
	
}
