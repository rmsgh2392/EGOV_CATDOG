package com.mypet.web.user;

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
import org.springframework.web.bind.annotation.RestController;

import com.maypet.web.enums.Sql;
import com.mypet.web.cmm.IConsumer;
import com.mypet.web.cmm.IFunction;
import com.mypet.web.cmm.IPredicate;
import com.mypet.web.cmm.ISupplier;
import com.mypet.web.utl.Printer;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/users")

public class UserCtl {
	public static Logger logger = LoggerFactory.getLogger(UserCtl.class);
	@Autowired Map<String,Object> map;
	@Autowired User users;
	@Autowired Printer printer;
	@Autowired UserMapper userMapper;
	
	@GetMapping("/{uid}/exist")
	public Map<?, ?> existId(@PathVariable String uid){
		System.out.println("중복진입");
		IFunction<String,Integer> f = t -> userMapper.existId(uid);
		map.clear();
		map.put("msg",(f.apply(uid)==0) ? "SUCCESS":"FAIL");
		return map;
	}

	@PostMapping("/")  
	public Map<?,?> join(@RequestBody User param) {  
		printer.accept("로그인으로 들어옴:"+param.toString());
		IConsumer<User> c= t->userMapper.insertUser(t);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	@PostMapping("/{uid}")
	public User login(@PathVariable String uid, @RequestBody User param){
		IFunction<User,User> f = o-> userMapper.selectUserById(param);
		return f.apply(param);  
	}
	@GetMapping("/{uid}")
	public User searchUserById(@PathVariable String uid, @RequestBody User param) {
		IFunction<User,User> f = o-> userMapper.selectUserById(param);
		return f.apply(param);
	}

	@PutMapping("/{uid}")
	public Map<?,?> updateUser(@PathVariable String uid, @RequestBody User param) {
		IConsumer<User> c= t->userMapper.insertUser(t);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	@DeleteMapping("/{uid}")
	public Map<?,?> removeUser(@PathVariable String uid, @RequestBody User param) {
		IConsumer<User> c= t->userMapper.insertUser(t);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	@GetMapping("/create/table")
	public Map<?,?> createUser(){
		HashMap<String,String> paramMap = new HashMap<>();
		paramMap.put("CREATE_TABLE", Sql.CREAT_USER.toString());
		printer.accept("테이블 생성쿼리: \n"+paramMap.get("CREATE_TABLE"));
		IConsumer<HashMap<String, String>> c= t->userMapper.create_user(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
	@GetMapping("/drop/table")
	public Map<?,?> dropUser(){
		HashMap<String,String> paramMap = new HashMap<>();
		paramMap.put("DROP_TABLE", Sql.DROP_USER.toString());
		printer.accept("테이블 삭제 쿼리: \n"+paramMap.get("DROP_TABLE"));
		IConsumer<HashMap<String, String>> c= t->userMapper.create_user(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
	@GetMapping("/create/dogtable")
	public Map<?,?> createDog(){
		HashMap<String,String> paramMap = new HashMap<>();
		paramMap.put("CREATE_DOG", Sql.CREATE_DOG.toString());
		printer.accept("테이블 생성쿼리: \n"+paramMap.get("CREATE_DOG"));
		IConsumer<HashMap<String, String>> c= t->userMapper.create_dogs(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
	@GetMapping("/delete/dogtable")
	public Map<?,?> deleteDog(){
		HashMap<String,String> paramMap = new HashMap<>();
		paramMap.put("DROP_DOG", Sql.DROP_DOG.toString());
		printer.accept("테이블 생성쿼리: \n"+paramMap.get("DROP_DOG"));
		IConsumer<HashMap<String, String>> c= t->userMapper.delete_dogs(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
	


}
