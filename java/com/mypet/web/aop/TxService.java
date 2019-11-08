package com.mypet.web.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mypet.web.pxy.Proxy;
import com.mypet.web.util.Printer;

public class TxService {
	@Autowired Proxy pxy; //프록시 사무실
	@Autowired Printer printer;

	
	@SuppressWarnings("unchecked")//노란불 뜨면 그냥 잡아서 실행하면 됨
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServiceList = new ArrayList<>();
		printer.accept("tx서비스 들어옴");
		txServiceList.clear(); 
		txServiceList = (List<String>) pxy.crawl(paramMap);
		return txServiceList;
}
}
