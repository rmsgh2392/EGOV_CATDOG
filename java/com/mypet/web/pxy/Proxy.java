package com.mypet.web.pxy;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.Collections;
=======
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
<<<<<<< HEAD
import java.util.function.Supplier;
=======
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.brd.ArticleMapper;
import com.mypet.web.cmm.ISupplier;
import com.mypet.web.usr.User;
import com.mypet.web.usr.UserMapper;
import com.mypet.web.util.Printer;

import lombok.Data;

@Component
@Data
@Lazy
public class Proxy {
	private int pageNum,
				pageSize,
				startRow,
				endRow,
				nextBlock,
				prevBlock,
				startPage,
				endPage,
				totalCount,
				pageCount,
				blockCount,
				blockNum;
	private boolean existPrev, existNext;
	private String search;
	private final int BLOCK_SIZE = 5;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	@Autowired UserMapper userMapper;
	@Autowired ProxyMap map;
	
	/*크롤링 프록시 페이징네이션프록시 따로 만들어도 상관없다 웬만하면 같이 모아도된다.*/

	@SuppressWarnings("unused")
	public void paging() {
		ISupplier<String> s = ()->articleMapper.countArticle();
		totalCount = Integer.parseInt(s.get());
		printer.accept("전체 글 개수 : "+totalCount);
		pageCount = (totalCount%pageSize==0)? totalCount/pageSize : (totalCount/pageSize)+1;
//		startRow = (pageNum * pageSize)-pageSize
		startRow = (pageNum-1)*pageSize;
//		endRow = (pageSize % 5 == 0) ? startRow + 4 : startRow + (pageSize % 5);
//		endRow = startRow + (5 * pageNum);
		//endRow = startRow +4
		endRow = (pageNum == pageCount) ? totalCount-1 : startRow + pageSize -1;
	    blockCount = (pageCount%BLOCK_SIZE==0)? pageCount/BLOCK_SIZE : (pageCount/BLOCK_SIZE)+1;
	    blockNum = (pageNum-1)/BLOCK_SIZE;
		startPage = (blockNum * BLOCK_SIZE)+1; //page 는 1부터 찍게 하자 그래서 +1 따로 자바스크립트에서 추가하지말고 
		endPage = (blockNum == (blockCount-1)) ? pageCount : (blockNum * 5) + BLOCK_SIZE;
		//endpage = (blockNum == blockCount) ? blockCount -1 : startPage + BLOCK_SIZE;
		//endpage = ((bl20ockNum+1) == blockCount) ? pageCount : startPage + (BLOCK_SIZE -1); --> 다른사람들 알고리즘 
//		boolean existPrev = false;
		// boolean existPrev = blockCount > 1
		if(blockNum != 0) {
			existPrev = true;
		}else {
			existPrev = false;
		}
		existNext = (blockCount-1) != blockNum;
		//(blockNum +1) != blockCount;
//		if((blockCount-1) != blockNum) {
//			existNext = true;
//		}else {
//			existNext = false;
//		}
		nextBlock = startPage + BLOCK_SIZE;
		prevBlock = startPage - BLOCK_SIZE;
			
//			 pages = BLOCK_SIZE;
	}
	public int parseInt(String param) {
		Function<String, Integer> f = t ->Integer.parseInt(t);
		return f.apply(param);
	}
	
	public List<?> crawl(Map<?,?> paramMap){
		String url = "https://"+paramMap.get("site")+"/";
		printer.accept("프록시에 들어옴 넘어온 url \n" +url);
		List<String> proxyList = new ArrayList<>();
		proxyList.clear();
		try {
			Connection.Response respone = Jsoup.connect(url).method(Connection.Method.GET).execute();
			Document document = respone.parse();
			String text = document.html();
			proxyList.add(text);
			printer.accept("크롤링한 값  \n: "+text);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return proxyList;
	}
	public int random(int a, int b) {
		printer.accept("ctrl에서 넘어온 파라미터 값 :"+a +','+ b );
		BiFunction<Integer, Integer, Integer> f = (t,u) -> (int) (Math.random()*(u-t))+t;
		f.apply(a,b);
		return f.apply(a,b); 
	}
	
	public String setSsn() {
		String ssn = "";
        int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int iMinMonth = 1;
        int iMaxMonth = 12;
        int iRandomMonth = (int)(Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
        int iRandomDay = (int)(Math.random() * (maxDays[iRandomMonth-1] -2) + 1);
        return  ssn;
    }
	public String makeUserid() {
		List<String> idE = 
		Arrays.asList("a","b","c","d","e","f","g"
		,"h","i","j","k","l","n","m","o","p"
		,"q","r","s","t","u","v","w","x","y","z",
		"A","B","C","D","E","F","G",
		"H","I","J","K","L","N","M","O","P"
		,"Q","R","S","T","U","V","W","X","Y","Z",
		"0","1","2","3","4","5","6","7","8","9");
		Collections.shuffle(idE);
		return idE.get(0) + idE.get(1)+idE.get(2)+idE.get(3)+idE.get(4);	
	}
	public String userPhone() {
		return String.format("03%d-%4d-%4d",this.random(1,10),this.random(1,9999),this.random(1,9999));
	}
	public String userAddress() {
		return "";
	}
	public String userEmail() {
		return "";
	}
	public String makeUserName() {
		 List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
			        "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
			        "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
			        "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
			        "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
			    List<String> name = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
			        "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
			        "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
			        "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
			        "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
			        "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
			        "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
			        "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
			        "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
			        "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
			    Collections.shuffle(fname);
			    Collections.shuffle(name);
			   String fullname = fname.get(0) + name.get(0) + name.get(1);
			   return fullname;
	}
	public String setpetType() {
		List<String> 성 = Arrays.asList();
		return "";
	}
	public User makeUsers(){
			   return new User(makeUserid(),
					   		   "1",
					   		   setSsn(),
					   		   makeUserName(),
					   		   userPhone(),
					   		   userAddress(),
					   		   userEmail(),
					   		   setpetType());
	}
	@Transactional
	public void insertUsers() {
		for(int i=0;i<500; i++) {
//			Function<User,User> f = t -> userMapper.insertUser(makeUsers());
			userMapper.insertUser(makeUsers());
			
		}
	}
	
}
=======
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.mypet.web.brd.ArticleMapper;
import com.mypet.web.cmm.ISupplier;
import com.mypet.web.utl.Printer;

import lombok.Data;

@Component @Data @Lazy
public class Proxy {
	private int totalCount, startRow, endRow,
				pageCount, pageNum, pageSize, startPage, endPage,
				blockCount, blockNum, nextBlock, prevBlock;
	private boolean existPrev,existNext;
	private String search;
	private final int BLOCK_SIZE = 5;
	private List<Integer> pages;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	
	@SuppressWarnings("unused")
	public void paging() {
		ISupplier<String> s = ()->articleMapper.countArtseq();
		totalCount = Integer.parseInt(s.get());
		pageCount = totalCount % pageSize == 0 ? 
					(totalCount / pageSize):((totalCount / pageSize) + 1);
		startRow = pageSize*(pageNum-1);
		endRow = (pageNum == pageCount) ? totalCount -1 : startRow +pageSize -1;
		
		blockCount = pageCount % BLOCK_SIZE == 0 ? (pageCount / BLOCK_SIZE):((pageCount / BLOCK_SIZE) + 1); //count 는 총수?
		blockNum = (pageNum -1) / BLOCK_SIZE; //num 인덱스 넘버? 그래서 0부터 시작?
		startPage = blockNum * BLOCK_SIZE + 1;
		endPage = ((blockNum+1)!= blockCount) ? (startPage+BLOCK_SIZE-1) : pageCount;
		existPrev = blockNum != 0;
//      트루 펄스면 3항은 이것처럼 생략할 수 있음 . boolean existPrev = (blockNum != 0)? true : false;
		existNext = (blockNum + 1) != blockCount;
//		boolean existNext = (blockNum + 1 != blockCount)? true : false;
		
		
		pages = null;
//		for(int i = startPage; i <= endPage; i++) {
//			pages.add(i);
//		}
		List<Integer> x = new ArrayList<Integer>();
		for(int i = startPage; i<= endPage ; i++) {
			x.add(i);
		}
		pages = x;
		System.out.println("페이지수"+pages);
		nextBlock = startPage + pageSize ;
		prevBlock = startPage - pageSize;
		
		
	}
	public int parseInt(String param) {
		Function<String,Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
	}
	
	
	public void accept(Map<?,?> paramMap) {
		String pageNum = (String) paramMap.get("");
	}

	public int random(int a,int b) {
		BiFunction<Integer, Integer, Integer> f = (t,u) ->(int)(Math.random()*(u-t)+t) ;
		return f.apply(a,b);
	}
	
	public List<?> crwal(Map<?,?> paramMap){
		List<String> proxyList = new ArrayList<>();
		String url = "http://"+paramMap.get("site")+"/";
		printer.accept("넘어온 url\n"+url);
		try {
			Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();
			Document document = response.parse();
			String text = document.html();
//			String text = document.text();
			printer.accept("크롤링한 텍스트\n"+text);
			proxyList.add(text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proxyList;
	}
	
	public static void main(String[] args) {
		try {
			Document rawData = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10*1000).get();
			  Elements artist = rawData.select("p[class=artist]"); 
			  Elements title = rawData.select("p[class=title]"); 
			  List<String> artist2 = new ArrayList<>();
			  List<String> title2 = new ArrayList<>();
			  for(Element e : artist) {
				  artist2.add(e.text());
			  }
			  for(Element e : title) {
				  title2.add(e.text());
			  }
			  System.out.println(artist2); 
			  System.out.println("---------------");
			  System.out.println(title2); 

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	

}
>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
