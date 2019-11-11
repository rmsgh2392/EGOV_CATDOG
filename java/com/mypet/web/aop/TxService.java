package com.mypet.web.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.pxy.Proxy;
<<<<<<< HEAD
import com.mypet.web.usr.User;
import com.mypet.web.usr.UserMapper;
import com.mypet.web.util.Printer;
//@Transactional 비추 클래스에 다 걸어버리면 트랜젝션을 안사용하는것도 걸리기 떄문에 느려진다 그래서 사용하는 것만 어노테이션 붙여준다.
@Service
public class TxService {
	@Autowired Proxy pxy; //프록시 사무실
	@Autowired Printer printer;
	@Autowired UserMapper userMapper;
	@Autowired TxMapper txMapper;

	
	@SuppressWarnings("unchecked")//노란불 뜨면 그냥 잡아서 실행하면 됨
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServiceList = new ArrayList<>();
		printer.accept("tx서비스 들어옴");
		txServiceList.clear(); 
		txServiceList = (List<String>) pxy.crawl(paramMap);
		return txServiceList;
	}
	@Transactional
	public int registerUsers(){
		List<User> list = new ArrayList<>();
		for(User user : list) {
			txMapper.insertUser(user);
		}
		int userCount = userMapper.countUsers();
		return userCount;
	}
=======

@Transactional
@Service
public class TxService {
	@Autowired TxMapper mapper;
	@Autowired Proxy pxy;
//	@Autowired List<String> txServicelist;
	
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
		txServicelist = (List<String>) pxy.crwal(paramMap);
		return txServicelist;
	}
	
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
}
