package com.mypet.web.brd;

import java.util.Arrays;
import java.util.HashMap;
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
import com.mypet.web.cmm.IPredicate;
import com.mypet.web.cmm.ISupplier;
import com.mypet.web.cur.CustomerCtrl;
import com.mypet.web.enums.SQL;
import com.mypet.web.pxy.Proxy;
import com.mypet.web.pxy.ProxyMap;
import com.mypet.web.utl.Printer;

@RestController
@RequestMapping("/articles")//상수풀로 처리 
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Article article;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	@Autowired List<Article> list;
	@Autowired Proxy pxy;
	@Autowired ProxyMap map;

	
	
	@PostMapping("/")
	public Map<?,?> writer(@RequestBody Article param ) {
		printer.accept("brdctrl에 들어옴");
		param.setBoardType("마이펫 게시판");
		printer.accept(param.toString());
		IConsumer<Article> c = t-> articleMapper.insertArticle(param);
		c.accept(param);
		//파라미터와 리턴 사이에 =>에로우펑션을 쓴다. 람다 ~~
		//한줄이면 블락 생략 가능 위에 제네릭스로 아티클이라는 객체가 이미 타입이 있어서 아티클도 제거 
		ISupplier<String> s = ()-> articleMapper.countArticle();
		map.accpet(Arrays.asList("msg","count"),
				Arrays.asList("SUCCESS", s.get()));
		return map.get();
	}
//	@PostMapping("/{articleseq}")
//	public Map<?,?> deleteArticle(@PathVariable String articleseq , @RequestBody Article param ){
//		printer.accept("삭제하고싶음 들어와");
//		map.clear();
//		IConsumer<Article> c = t-> articleMapper.deleteArticle(t);
//		c.accept(param);
//		map.put("msg","success");
//		printer.accept("map ::" +map);
//		return map;
//	}
	@GetMapping("/page/{pageNo}/size/{pageSize}")
	public Map<?,?> list(@PathVariable String pageNo,
			@PathVariable String pageSize){
		System.out.println("넘어온 페이지 넘버 : "+pageNo);
		pxy.setPageNum(pxy.parseInt(pageNo));
		pxy.setPageSize(pxy.parseInt(pageSize));
		pxy.paging();
		list.clear();//하기전에 깨끗이 클리어하고 하자 !!
		ISupplier<List<Article>> s = ()-> articleMapper.selectAll(pxy);//제네릭스 안에 제네릭스가 들어갈 수 있다.
		printer.accept("해당 페이지 글목록 :\n"+ s.get());
		int ran = pxy.random(1000, 10000000);
		System.out.println("랜덤 수 : " + ran);
		map.accpet(Arrays.asList("articles","pxy")
				,Arrays.asList(s.get(),pxy));
		return map.get();
	}
	@GetMapping("/count")
	public Map<?,?> count(){
		ISupplier<String> s =()-> articleMapper.countArticle();
		printer.accept("카운팅 : " +s.get());
		map.accpet(Arrays.asList("count"), Arrays.asList(s.get()));
		return map.get();
	}
	@GetMapping("/create/table")
	public Map<?, ?> createArticles(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_ARTICLES", SQL.CREATE_ARTICLES.toString());
		 IConsumer<HashMap<String, String>> c = o->articleMapper.createArticles(o);
		 c.accept(paramMap);
		 paramMap.clear();
		 paramMap.put("msg", "SUCCESS");
		 return paramMap;
	}
	
//	@PutMapping("/{articleseq}")
//	public Article UpdateArticle(@PathVariable String articleseq ,@RequestBody Article param) {
//		printer.accept("put에 들어옴");
//		list.clear();
//		IConsumer<Article> c = t-> articleMapper.updateArticle(t);
//		c.accept(param);
//		IFunction<Article,Article> f= t->articleMapper.getArticle(t);
////		f.apply(param);
//		printer.accept("전체글목록 "+f.apply(param));
//		return f.apply(param);
//	}
	@GetMapping("/{articleseq}")
	public Article read(@PathVariable String articleseq , @RequestBody Article param) {
		//@PathVariable String articleseq url에 있는 변수 : /articles/{articleseq}
		//상태라는 개념!! 값이 상수상태냐 변수 상태냐 데이터가 변할 수 있는 상태냐 없는 상태냐 
		//path중에서 바뀔 수 있는 부분 
		return null;
	}
	@PutMapping("/{articleseq}")
	public Article update(@PathVariable String articleseq, @RequestBody Article param) {
		return null;
	}
	@DeleteMapping("/{articleseq}")
	public Map<?,?> removeArticle(@PathVariable String articleseq, @RequestBody Article param) {
		return null;
	}
}