package com.mypet.web.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mypet.web.pxy.Proxy;
import com.mypet.web.util.Printer;

public class TxController {
	@Autowired Printer printer;
	@Autowired Proxy proxy;
	@Autowired TxService txService;
	
	@GetMapping("/crawling/{site}/{srch}")//restful의 방식은 아님 id가 아니기 떄문
	public Map<?,?> crawl(@PathVariable String site, @PathVariable String srch){
		//getJSON은 리퀘스트 바디 안걸음 패스 배류어블만
		printer.accept("tx 컨트롤러 들어옴 사이트 :"+site+", 서치 :"+srch);
		HashMap<String,Object> map = new HashMap<>();
		map.clear();
		map.put("site",site);
		map.put("srch",srch);
		map.put("text",txService.crawling(map));
		txService.crawling(map);
		printer.accept("보낸 값 :"+txService.crawling(map));
		return map;
	}
}
