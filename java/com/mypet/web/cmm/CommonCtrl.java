package com.mypet.web.cmm;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CommonCtrl.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String facade(Locale locale, Model model) {
		logger.info("역시 갓 대한민국");
		return "index";
	}
		
}
