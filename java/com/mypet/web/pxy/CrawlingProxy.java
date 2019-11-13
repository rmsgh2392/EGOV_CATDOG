package com.mypet.web.pxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mypet.web.enums.Path;
@Component("crawler")
public class CrawlingProxy extends Proxy{
	@Autowired Box<String> box;
	
	public Box<String> choose(Map<?,?> paramMap){
		System.out.println("키값은?" + paramMap.get("site"));
		System.out.println("값은?" + paramMap.get("srch"));
		String url = "";
		switch (string(paramMap.get("srch"))) {
		case "스톤애견풀빌라":
			box = crawling(Path.CRAWLING_TARGET.toString());
		break;
		default :
			crawling("https://"+paramMap.get("site")+"/");
			break;
	}
		return box;
   }

	private Box<String> crawling(String url) {
		System.out.println("넘어온 url :" +url);
		box.clear();
		try {
			Document rawData = Jsoup.connect(url).timeout(100*1000).get();
			Elements title = rawData.select("div[class=review_txt]");
			
			for(Element e : title) {
				box.add(e.text()+"\n *********** \n");
			}
			System.out.println(box);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return box;
	}
}
//		String url = "https://"+paramMap.get("site")+"/";
//		System.out.println("넘어온 url" +url);
//		List<String> proxyList = new ArrayList<>();
//		proxyList.clear();
//		try {
//			Connection.Response respone = Jsoup.connect(url).method(Connection.Method.GET).execute();
//			Document document = respone.parse();
//			String text = document.html();
//			proxyList.add(text);
//
//
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//		
//		return proxyList;
//	}

