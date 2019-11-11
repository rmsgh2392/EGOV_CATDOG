package com.mypet.web.aop;

<<<<<<< HEAD
import java.util.Arrays;
=======
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.pxy.Proxy;
import com.mypet.web.pxy.ProxyMap;
import com.mypet.web.util.Printer;
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.utl.Printer;

>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	@Autowired Printer printer;
	@Autowired TxService txService;
<<<<<<< HEAD
	@Autowired ProxyMap map;
	
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
	@GetMapping("/register/users")//restful의 방식은 아님 id가 아니기 떄문
	public	Map<?,?> registerUsers(){
		int userCount = txService.registerUsers();
		map.accept(Arrays.asList("userCount"),Arrays.asList(userCount));
		return map.get();
	}
=======
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

>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
}
