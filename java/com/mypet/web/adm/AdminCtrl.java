package com.mypet.web.adm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.cmm.IFunction;
import com.mypet.web.enums.SQL;
import com.mypet.web.util.Printer;

@RestController
@RequestMapping("/admins")
public class AdminCtrl {
	@Autowired Admin admin;
	@Autowired AdminMapper adminMapper;
//	@Autowired Map<String,Object> map;
	@Autowired List<Admin> adminList;
	@Autowired Printer printer;
	
	
	@PostMapping("/")
	public Map<?,?> register(@RequestBody Admin param){
		return null;
	}
	
	@PostMapping("/{aid}")
	public Map<?,?> access(@PathVariable String aid ,@RequestBody Admin param){
		printer.accept(param.toString());
		printer.accept("admin 컨트롤러 access들어옴");
		Map<String,Object> map = new HashMap<>();
		IFunction<Admin,Admin> f = t-> adminMapper.access(t);
		map.clear();
		map.put("msg", (f.apply(param) !=null) ? "success" : "fail");
		printer.accept("db값" +f.apply(param));
		return map;
//		f.apply(param) !=null ? "success" : "fail"
	}
	@GetMapping("/create/table")
	public Map<?,?> createAdmin(){
		System.out.println("관리자 테이블 생성들어옴");
		HashMap<String,String> paramMap = new HashMap<>();
		paramMap.put("CREATE_ADMIN",SQL.CREATE_ADMIN.toString());
		Consumer<HashMap<String,String>> c = t-> adminMapper.createAdmin(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg","success");
		return paramMap;
	}
	@GetMapping("/{aid}")
	public List<Admin> selectAdmin(@PathVariable String aid , @RequestBody Admin param){
		return adminList;
	}
	@PutMapping("/{aid}")
	public Admin updateAdmin(@PathVariable String aid ,@RequestBody Admin param) {
		return admin;
	}
	@DeleteMapping("{aid}")
	public Map<?,?> deleteAdmin(@PathVariable String aid , @RequestBody Admin param){
		return null;
	}
}
