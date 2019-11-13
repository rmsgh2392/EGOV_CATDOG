package com.mypet.web.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i=1; i<5; i++) {
			 crawler(i);
		}
	}
		
/*		try {
			Document rawData = Jsoup.connect("https://store.naver.com/accommodations/detail?entry=pbl&id=1285629759&matchSidRoomIds=2866643%2C2866668%2C2866673%2C2866675%2C2866676%2C2866686%2C2866690%2C2866700%2C2866703%2C2866709%2C2866725%2C2866730%2C2865938%2C2866732%2C2866606%2C2866741%2C2866612%2C2866746%2C2866616%2C2866758%2C2866621%2C2866624%2C2866633%2C2866636&query=%EC%8A%A4%ED%86%A4%EC%95%A0%EA%B2%AC%ED%92%80%EB%B9%8C%EB%9D%BC&tab=bookingReview&tabPage=0").timeout(10*1000).get();
			Elements title = rawData.select("div.review_txt");
//			Elements address = rawData.select("span[class=search_text address]");
			
			
//			Elements artist = rawData.select("aside[class=recommendReview] p");
//			Elements title = rawData.select("p[class=title]");
//			List<String> artist2 = new ArrayList<>();
			List<String> title2 = new ArrayList<>();
			List<String> address2 = new ArrayList<>();
			for(Element e : title) {
				title2.add(e.text());
			}
//			for(Element e : address) {
//				address2.add(e.text());
//			}
			
			 * for(Element e : title) { title2.add(e.text()); }
			 
			System.out.println(title2);
			System.out.println("-----------------------------------");
//			System.out.println(address2);
		}catch(Exception e2) {
			e2.printStackTrace();
		}*/
	public static void crawler(int i) {
		try {
			Document rawData = Jsoup.connect("http://www.ppomppu.co.kr/zboard/zboard.php?id=freeboard&page="+i+"&divpage=1251").timeout(10*1000).get();
			Elements title = rawData.select("a font[class=list_title]");
			List<String> title2 = new ArrayList<>();
			for(Element e : title) {
				title2.add(e.text()+"\n =========== \n");
			}
			System.out.println(title2);
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
//	public static void crawler(int i) {
		
	}
	

