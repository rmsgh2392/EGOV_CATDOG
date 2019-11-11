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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maypet.web.enums.Sql;
import com.mypet.web.user.UserMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CmmCtr {
	@Autowired UserMapper userMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(CmmCtr.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value="/cmm/create/db", method = RequestMethod.GET)
	public @ResponseBody Map<?,?> createDb(){			//이렇게 하면 soap 방식 에서 이 메서드만 rest 방식으로 바뀐다.
		HashMap<String, String> map = new HashMap<>();
		map.put("CREATE_DB", Sql.CREAT_DB.toString());
		Consumer<HashMap<String, String>> c = o ->userMapper.createDB(o);
		c.accept(map);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	
}
