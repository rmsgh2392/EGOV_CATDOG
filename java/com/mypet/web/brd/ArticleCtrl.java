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
import com.mypet.web.utl.Printer;

@RestController
@RequestMapping("/articles")

public class ArticleCtrl {
	private static final Logger Logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired ProxyMap map;
	@Autowired Article article;
	@Autowired ArticleMapper articleMapper;
	@Autowired Printer printer;
	@Autowired List<Article> list;
	@Autowired Proxy pxy;
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Article param){
		param.setBoardtype("게시판");
		IConsumer<Article> c = o -> articleMapper.insertArticle(param);
		c.accept(param);
		ISupplier<String> s = () -> articleMapper.countArticle();
		map.accept(Arrays.asList("msg", "count"), Arrays.asList("Success", s.get()));
		return map.get();
	}
	@GetMapping("/{articleseq}")
	public Article read(@PathVariable @RequestBody Article param){
		return null;
	}
	
	@PutMapping("/{articleseq}")
	public Article editArticle(@PathVariable String articleseq, @RequestBody Article param){
		list.clear();
		IConsumer<Article> c = o-> articleMapper.editArticle(o);
		c.accept(param);
		IFunction<Article, Article> f = t-> articleMapper.getArticle(t);
		return f.apply(param);
	}
	@DeleteMapping("/{articleseq}")
	public Map<?,?> deleteArticle(@PathVariable String articleseq, @RequestBody Article param){
		IConsumer<Article> c = o-> articleMapper.deleteArticle(o);
		map.accept(Arrays.asList("msg"), Arrays.asList("Success"));
		c.accept(param);
		return map.get();
	}
	@GetMapping("/count")
	public Map<?,?> countNum() {
		ISupplier<String> s = () -> articleMapper.countArticle();
		map.accept(Arrays.asList("count"), Arrays.asList(s.get()));
		return map.get();
	}
	@GetMapping("/page/{pageNo}/size/{pageSize}")
	public Map<?,?> list(@PathVariable String pageNo,
			@PathVariable String pageSize) {
		pxy.setPageNum(pxy.parseInt(pageNo));
		pxy.setPageSize(pxy.parseInt(pageSize));
		pxy.paging();
		ISupplier<List<Article>> s =()-> articleMapper.selectAll(pxy);
		map.accept(Arrays.asList("articles","pxy"), Arrays.asList(s.get(),pxy));
		return map.get();
	}
}
