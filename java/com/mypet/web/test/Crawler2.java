package com.mypet.web.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler2 {
	
	private void crawling(String url) {
	System.out.println("넘어온 url :" +url);
	try {
		Connection.Response respone = Jsoup.connect("").method(Connection.Method.GET).execute();
		Document document = respone.parse();
		String text = document.text();
		System.out.println("=========================");
		System.out.println(text);
	


	} catch (Exception e2) {
		e2.printStackTrace();
	}
	}
}
