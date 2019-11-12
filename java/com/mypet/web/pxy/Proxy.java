package com.mypet.web.pxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.springframework.stereotype.Component;
@Component
public class Proxy {
	public int parseInt(String param) {
		Function<String, Integer> f = t ->Integer.parseInt(t);
		return f.apply(param);
	}
	public int random(int a, int b) {
//		printer.accept("ctrl에서 넘어온 파라미터 값 :"+a +','+ b );
		BiFunction<Integer, Integer, Integer> f = (t,u) -> (int) (Math.random()*(u-t))+t;
		f.apply(a,b);
		return f.apply(a,b); 
	}
}


 