package com.mypet.web.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	@Autowired Printer printer;
	@Autowired TxService txService;
//	@Autowired HashMap<String, String> map;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site, @PathVariable String srch){
		HashMap<String, String> map = new HashMap<>();
		printer.accept(site+", srch"+srch);
		map.clear();
		map.put("site", site);
		map.put("srch", srch);
		
		txService.crawling(map);

	}

}
