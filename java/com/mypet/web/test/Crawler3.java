package com.mypet.web.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler3 {
	public static void main(String[] args) {
		try {
			Document rawData = Jsoup.connect("https://ko.wikipedia.org/wiki/%EB%B6%84%EB%A5%98:%EA%B0%9C_%ED%92%88%EC%A2%85").timeout(10*1000).get();
			Elements dog = rawData.select("td [class=navbox-list navbox-odd]");
			Elements dog1 = rawData.select("td [class=navbox-list navbox-even]");
			Elements dog3 = rawData.select("td [class=navbox-list navbox-odd]");
			Elements dog4 = rawData.select("td [class=navbox-list navbox-even]");
			
			
			List<String> species = new ArrayList<>();
			List<String> species1 = new ArrayList<>();
			List<String> species2 = new ArrayList<>();
			for(Element e : dog) {
				species.add(e.text());
			}
			for(Element e : dog1) {
				species1 .add(e.text());
			}
			for(Element e : dog3) {
				species2 .add(e.text());
			}
			 
			System.out.println(species+",");
			System.out.println("-----------------------------------");
			System.out.println(species1+",");
			System.out.println("-----------------------------------");
			System.out.println(species2+",");
//			System.out.println(address2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
