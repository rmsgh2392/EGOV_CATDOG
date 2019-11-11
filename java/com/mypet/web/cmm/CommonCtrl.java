package com.mypet.web.cmm;

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
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mypet.web.enums.SQL;
import com.mypet.web.usr.UserMapper;

@Controller
public class CommonCtrl {
	@Autowired UserMapper userMapper;
	private static final Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String facade(Locale locale, Model model) {
		logger.info("역시 갓 대한민국");
		return "index";
	}
	
	@RequestMapping(value="/cmm/create/db")//get방식은 디폴트라 생략 가능 method = RequestMethod.GET)
	public @ResponseBody Map<?,?> createCatdogdb(){//@ResponseBody를 쓰면 이 메서드만 rest방식으로 바뀐다.
		HashMap<String,String> paramMap = new HashMap<>();
		System.out.println("데이터베이스 생성 들어옴");
		paramMap.put("CREATE_DB",SQL.CREATE_DB.toString());
		Consumer<HashMap<String,String>> c = t-> userMapper.createCatdogDb(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg","success");
		return paramMap;
	}
		
}
