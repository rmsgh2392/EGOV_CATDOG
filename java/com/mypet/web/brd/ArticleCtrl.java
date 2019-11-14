package com.mypet.web.brd;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mypet.web.pxy.PageProxy;
import com.mypet.web.pxy.Proxy;
import com.mypet.web.pxy.Trunk;
import com.mypet.web.enums.Path;
import com.mypet.web.enums.SQL;
import com.mypet.web.pxy.Box;
import com.mypet.web.pxy.FileProxy;

//import com.mypet.web.util.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Articles article;
	@Autowired ArticleMapper articleMapper;
	@Autowired Box<Articles> box;
	@Autowired PageProxy pager;
	@Autowired Proxy proxy;
	@Autowired Trunk<Object> trunk; // Trunk<Object> trunk에서 Object를 넣어주면 트렁크 안에 있는 모든 메서드들의 <T>로 선언된 곳의 Object가 들어간다. 
	@Autowired FileProxy filemgr;
	@PostMapping("/")
	public Map<?,?> UpdateWrite(@RequestBody Articles param ) {
		//파라미터와 리턴 사이에 =>에로우펑션을 쓴다. 람다 ~~
		//한줄이면 블락 생략 가능 위에 제네릭스로 아티클이라는 객체가 이미 타입이 있어서 아티클도 제거 
		System.out.println("brdctrl에 들어옴");
		param.setCategory("마이펫 게시판");
		System.out.println("uid :" +param.toString());
		Consumer<Articles> c = t-> articleMapper.insertArticle(t);
		c.accept(param);
		System.out.println("box ::" +trunk);
		Supplier<Integer> s = ()-> articleMapper.countArticles();
		trunk.accept(Arrays.asList("msg","count"),
				Arrays.asList("success",s.get()));
		return trunk.get();
	}
	@PostMapping("/{articleseq}")
	public Map<?,?> deleteArticle(@PathVariable String articleseq , @RequestBody Articles param ){
		System.out.println("삭제하고싶음 들어와");
		Consumer<Articles> c = t-> articleMapper.deleteArticle(t);
		box.clear();
		c.accept(param);
		trunk.accept(Arrays.asList("msg"),Arrays.asList("success"));
		System.out.println("box ::" +trunk);
		return trunk.get();
	}
	
	@GetMapping("/page/{pageNo}/size/{pageSize}")//외부에서 페이지 번호만 들어옴 
	public Map<?,?> list(@PathVariable String pageNo,@PathVariable String pageSize){
		System.out.println("게시판 페이지 들어옴");
		pager.setPageNum(proxy.parseInt(pageNo));
		pager.setPageSize(proxy.parseInt(pageSize));
		pager.paging();
		box.clear();
		Supplier<List<Articles>> s = ()-> articleMapper.selectAllArticle(pager);//제네릭스 안에 제네릭스가 들어갈 수 있다.
		System.out.println("해당페이지 :\n"+ s.get());
//		int ran = pager.random(3,11);
//		System.out.println("랜덤값 :"+ran);
		
		trunk.accept(Arrays.asList("articles","proxy"),Arrays.asList(s.get(),pager));
		return 	trunk.get();
	}
	
	//SQL에서 테이블을 제거하는게 아니라 자바에서 Articles table 생성하는 메서드
	@GetMapping("/create/table")
	public Map<?,?> createArticle(){
		System.out.println("게시판 테이블 생성들어옴");
		HashMap<String,String> paramMap = new HashMap<>();
		paramMap.put("CREATE_ARTICLES",SQL.CREATE_ARTICLES.toString());
		System.out.println("테이블생성 들어옴"+paramMap.get("CREATE_ARTICLES"));
		Consumer<HashMap<String,String>> c = t-> articleMapper.createArticles(paramMap);;
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg","success");
		System.out.println("테이블 생성 결과 값 : "+paramMap);
		return paramMap;
	}
	//SQL에서 테이블을 제거하는게 아니라 자바에서 Articles table 삭제하는 메서드
	@GetMapping("/drop/table")
	public Map<?,?> dropArticle(){
		System.out.println("게시판 테이블 삭제들어옴");
		HashMap<String,String> paramMap = new HashMap<>();
		paramMap.put("DROP_ARTICLES",SQL.DROP_ARTICLES.toString());
		System.out.println("테이블생성 들어옴"+paramMap.get("DROP_ARTICLES"));
		Consumer<HashMap<String,String>> c = t-> articleMapper.dropArticles(paramMap);;
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg","success");
		System.out.println("테이블 삭제 결과 값 : "+paramMap);
		return paramMap;
	}
	
	@GetMapping("/{articleseq}")
	public Map<?,?> readArticleseqByCid(@PathVariable String board_type , @RequestBody Articles param) {
		return null;
		//@PathVariable String articleseq url에 있는 변수 : /articles/{articleseq}
		//상태라는 개념!! 값이 상수상태냐 변수 상태냐 데이터가 변할 수 있는 상태냐 없는 상태냐 
		//path중에서 바뀔 수 있는 부분 

	}
	
	@PostMapping("/fileupload")
	public void fileupload(MultipartFile[] uploadFile) {
		System.out.println("파일업로드 컨트롤러 들어옴");
		filemgr.fileupload(uploadFile);
		
	}
//	private void fileupload(MultipartFile[] uploadFile) {
//		String uploadFolder = Path.UPLOAD_PATH.toString();
//		for(MultipartFile f : uploadFile) {
//			String fname = f.getOriginalFilename();
//			fname = fname.substring(fname.lastIndexOf("\\")+1);
//			File saveFile = new File(uploadFolder,fname);
//			try {
//				f.transferTo(saveFile);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}
}


