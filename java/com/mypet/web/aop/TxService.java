package com.mypet.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.pxy.Proxy;

@Transactional
@Service
public class TxService {
	@Autowired TxMapper mapper;
	@Autowired Proxy pxy;
//	@Autowired List<String> txServiceList;
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(HashMap<?, ?> paramMap){
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
		txServicelist = (List<String>) pxy.crawl(paramMap);
		return txServicelist;
	}
}
