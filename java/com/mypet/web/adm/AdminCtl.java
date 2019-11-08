package com.mypet.web.adm;

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

import com.mypet.web.brd.ArticleCtl;
import com.mypet.web.cmm.IConsumer;
import com.mypet.web.cmm.IFunction;
import com.mypet.web.utl.Printer;

@RestController
@RequestMapping("/admins")
public class AdminCtl {
	public static Logger logger = LoggerFactory.getLogger(ArticleCtl.class);
	@Autowired Map<String,Object> map;
	@Autowired Admin admin;
	@Autowired Printer printer;
	@Autowired AdminMapper adminMapper;
	
	@PostMapping("/")
	public Map<?,?> register(@RequestBody Admin param){
		IConsumer<Admin> c = t->adminMapper.selectAdminByIdPw(param);
		c.accept(param);
		map.clear();
		map.put("msg","success");
		return null;
	}
	@PostMapping("/{aid}")
	public Map<?,?> access(@PathVariable String aid, @RequestBody Admin param){
		printer.accept(param.toString());
		IFunction<Admin, Admin> f = t-> adminMapper.selectAdminByIdPw(param);
		map.clear();
		map.put("msg",(f.apply(param)!=null) ? "SUCCESS" : "FAIL");
		return map;
			
	}
	
	@GetMapping("/{aid}")
	public Admin searchUserById(@PathVariable String param) {
		IFunction<String,Admin> f = t-> adminMapper.selectAdminById(param);
		return f.apply(param);
	}
	
	@PutMapping("/{aid}")
	public Map<?,?> updateAdmin(@PathVariable String aid, @RequestBody Admin param) {
		IConsumer<Admin> c = o -> adminMapper.updateAdmin(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	
	@DeleteMapping("/{aid}")
	public Map<?,?> removeUser(@PathVariable String uid, @RequestBody Admin param) {
		IConsumer<Admin> c = o->adminMapper.deleteAdmin(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	
}
