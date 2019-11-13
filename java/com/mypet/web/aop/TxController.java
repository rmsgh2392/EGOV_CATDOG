package com.mypet.web.aop;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mypet.web.pxy.Box;
import com.mypet.web.pxy.CrawlingProxy;
import com.mypet.web.pxy.Proxy;
import com.mypet.web.pxy.Trunk;


@RestController
@RequestMapping("/tx")
@Transactional
public class TxController {
	@Autowired TxService txService;
	@Autowired Trunk<String> trunk;
	@Autowired CrawlingProxy crawler;
	@Autowired Box<String> box;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site, @PathVariable String srch) {
		System.out.println(site +", srch" + srch);
		trunk.accept(Arrays.asList("site", "srch"), Arrays.asList(site, srch));
		 box = txService.crawling(trunk.get());
	}
	@GetMapping("/register/users")
	public Map<?,?> registerUsers() {
		int userCount = txService.registerUsers();
		System.out.println("서비스 카운팅 :::" + userCount);
		trunk.accept(Arrays.asList("userCount"), Arrays.asList(crawler.string(userCount)));
		return trunk.get();
	}
	@GetMapping("/write/info")
	public Map<?,?> writeArticles() {
		System.out.println("게시판 글 입력 들어옴");
		int articleCount = txService.writeArticles();
		System.out.println("서비스 카운팅 :::" + articleCount);
		trunk.accept(Arrays.asList("articleCount"), Arrays.asList(crawler.string(articleCount)));
		return trunk.get();
	}
	@GetMapping("/truncate/users")
	public Map<?,?> truncateUsers() {
		int userCount = txService.trucateUser();
		System.out.println("서비스 카운팅 :"+userCount);
		trunk.accept(Arrays.asList("userCount"),Arrays.asList(crawler.string(userCount)));
		return trunk.get();
	}

}
