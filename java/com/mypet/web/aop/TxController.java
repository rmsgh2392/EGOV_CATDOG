package com.mypet.web.aop;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.utl.Printer;

@RestController
@RequestMapping("/tx")
@Transactional
public class TxController {
	@Autowired TxService txService;
	@Autowired Printer printer;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void crawl(@PathVariable String site, @PathVariable String srch){
		HashMap<String, String> txMap = new HashMap<>();
		printer.accept(site+",검색어:"+srch);
		txMap.clear();
		txMap.put("site",site);
		txMap.put("srch",srch);
		txService.crawling(txMap);
	}
//	System.out.println(text);
}
