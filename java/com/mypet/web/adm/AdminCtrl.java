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
import com.mypet.web.cmm.IConsumer;
import com.mypet.web.cmm.IFunction;
import com.mypet.web.cur.Customer;
import com.mypet.web.cur.CustomerCtrl;
import com.mypet.web.cur.CustomerMapper;
import com.mypet.web.utl.Printer;

@RestController
@RequestMapping("/admins")
public class AdminCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CustomerCtrl.class);
	@Autowired Map<String, Object>map;
	@Autowired Admin admin;
	@Autowired Printer printer;
	@Autowired AdminMapper adminMapper;
	
//	@PostMapping("/")
//	public Map<?,?> register(@RequestBody Customer param) {
//		printer.accept(" join 들어옴 : "+param.toString());
//		IConsumer<Customer> c = o->adminMapper.selectAdminByIdPw(param);
//		c.accept(param);
//		map.clear();
//		map.put("msg", "SUCCESS");
//		return map;
//	}
	
	@PostMapping("/{aid}")
	public Map<?,?> access(@PathVariable String aid, @RequestBody Admin param) {
		printer.accept(param.toString());
	    printer.accept("admin 컨트롤러 access들어옴");
	    map.clear();
		IFunction<Admin,Admin> f = t-> adminMapper.selectAdminByIdPw(param);
		map.put("msg", (f.apply(param)!= null) ? "SUCCESS" : "FAIL");
		printer.accept("db값" +f.apply(param));
		return map;
//		f.apply(param)!= null ? "SUCCESS" : "FAIL"
	}
	
	@GetMapping("/{aid}")
	public Admin searchCustomerById(@PathVariable String param) {
		IFunction<String,Admin> f = t-> adminMapper.selectAdminById(param);
		return f.apply(param);
	}
	
	@PutMapping("/{aid}")
	public Map<?,?> updateCustomer(@PathVariable String uid, @RequestBody Admin param) {
		IConsumer<Admin> c = o->adminMapper.updateAdmin(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	
	@DeleteMapping("/{aid}")
	public Map<?,?> removeCustomer(@PathVariable String uid, @RequestBody Admin param) {
		IConsumer<Admin> c = o->adminMapper.deleteAdmin(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}

}