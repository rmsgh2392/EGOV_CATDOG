package com.mypet.web.pxy;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Lazy
public class ProxyMap {
	private HashMap<String,Object> map;
	public void accept(List<String> x, List<?> y) {
		map = new HashMap<>();
		for(int i=0; i < x.size(); i++) {
			map.put(x.get(i), y.get(i));
		}
		map.forEach((k,v)-> System.out.println(String.format("%s : %s",k,v)));
		//내부적으로 consumer 인터페이스가 작동 accept()메서드를 가지고 있음 
	}
	public HashMap<String, Object> get(){
		return map;
	}
}