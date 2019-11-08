package com.mypet.web.brd;

import java.util.Arrays;
import java.util.List;
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
import com.mypet.web.cmm.ISupplier;
import com.mypet.web.pxy.Proxy;
import com.mypet.web.pxy.ProxyMap;
import com.mypet.web.util.Printer;

@RestController
@RequestMapping("/atricles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Printer printer;
	@Autowired Articles article;
	@Autowired ProxyMap map;
	@Autowired ArticleMapper articleMapper;
	@Autowired List<Articles> list;
	@Autowired Proxy proxy;
	
	
	@PostMapping("/")
	public Map<?,?> UpdateWrite(@RequestBody Articles param ) {
		//파라미터와 리턴 사이에 =>에로우펑션을 쓴다. 람다 ~~
		//한줄이면 블락 생략 가능 위에 제네릭스로 아티클이라는 객체가 이미 타입이 있어서 아티클도 제거 
		printer.accept("brdctrl에 들어옴");
		param.setBoardType("마이펫 게시판");
		printer.accept("cid :" +param.toString());
		IConsumer<Articles> c = t-> articleMapper.insertArticle(t);
		c.accept(param);
		printer.accept("map ::" +map);
		ISupplier<String> s = ()-> articleMapper.countArticle();
		map.accept(Arrays.asList("msg","count"),
				Arrays.asList("success",s.get()));
		return map.get();
	}
	@PostMapping("/{articleseq}")
	public Map<?,?> deleteArticle(@PathVariable String articleseq , @RequestBody Articles param ){
		printer.accept("삭제하고싶음 들어와");
//		map.clear();
		IConsumer<Articles> c = t-> articleMapper.deleteArticle(t);
		c.accept(param);
		map.accept(Arrays.asList("msg"),Arrays.asList("success"));
//		map.put("msg","success");
//		printer.accept("map ::" +map);
		return map.get();
	}
	
	@GetMapping("/page/{pageNo}/size/{pageSize}")//외부에서 페이지 번호만 들어옴 
	public Map<?,?> list(@PathVariable String pageNo,@PathVariable String pageSize){
		proxy.setPageNum(proxy.parseInt(pageNo));
		proxy.setPageSize(proxy.parseInt(pageSize));
		proxy.paging();
		//하기전에 깨끗이 클리어하고 하자 !!
		ISupplier<List<Articles>> s = ()-> articleMapper.selectAllArticle(proxy);//제네릭스 안에 제네릭스가 들어갈 수 있다.
		printer.accept("해당페이지 :\n"+ s.get());
		int ran = proxy.random(3,11);
		printer.accept("랜덤값 :"+ran);
		
		map.accept(Arrays.asList("articles","proxy"),Arrays.asList(s.get(),proxy));
		return 	map.get();
	}
	
	@GetMapping("/{articleseq}")
	public Map<?,?> readArticleseqByCid(@PathVariable String board_type , @RequestBody Articles param) {
		//@PathVariable String articleseq url에 있는 변수 : /articles/{articleseq}
		//상태라는 개념!! 값이 상수상태냐 변수 상태냐 데이터가 변할 수 있는 상태냐 없는 상태냐 
		//path중에서 바뀔 수 있는 부분 
		return null;
	}
	
	@PutMapping("/{articleseq}")
	public Articles UpdateArticle(@PathVariable String articleseq ,@RequestBody Articles param) {
		printer.accept("put에 들어옴");
		list.clear();
		IConsumer<Articles> c = t-> articleMapper.updateArticle(t);
		c.accept(param);
		IFunction<Articles,Articles> f= t->articleMapper.getArticle(t);
//		f.apply(param);
		printer.accept("전체글목록 "+f.apply(param));
		return f.apply(param);
	}
	@DeleteMapping("/{articleseq}")
	public Map<?,?> removeArticle(@PathVariable String articleseq, @RequestBody Articles param) {
		return null;
	}

	@GetMapping("/count")
	public Map<?,?> count(){
		ISupplier<String> s = ()-> articleMapper.countArticle();
		printer.accept("카운트 값 :"+s.get());
		map.accept(Arrays.asList("count"),Arrays.asList(s.get()));
		return map.get();
	}
}
