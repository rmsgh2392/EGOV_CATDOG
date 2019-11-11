package com.mypet.web.cmm;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypet.web.cur.CustomerMapper;
import com.mypet.web.enums.SQL;
import com.mypet.web.utl.Printer;

@Controller
public class CommonCtrl {
	@Autowired CustomerMapper customerMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	@Autowired Printer p;
		class Test{
			void print() {
				p.accept("test 22");
			}
		}
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		new Test().print();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "index";
	}
	@RequestMapping(value="/cmm/create/db", method = RequestMethod.GET)// rest controller의 getMapping방식으로 치환 됨.
	public @ResponseBody Map<?,?> createDB(){ 				// @responseBody => rest방식으로 처리가능
		HashMap<String, String> map = new HashMap<>();
		map.put("CREATE_DB", SQL.CREATE_DB.toString());
		Consumer<HashMap<String, String>> c = o -> customerMapper.createCustomer(map);
		c.accept(map);
		map.clear();
		map.put("msg", "성공쓰");
		return map;
	}
}
