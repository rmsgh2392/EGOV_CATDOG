package com.mypet.web.pxy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import org.springframework.stereotype.Component;
@Component
public class Proxy {
	public int parseInt(String param) {
//		Function<String, Integer> f = t ->Integer.parseInt(t);
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	public String string(Object param) {
//		Function<String, Integer> f = t ->Integer.parseInt(t);
		Function<Object, String> f = String :: valueOf;
		return f.apply(param);
	}
	public boolean equals(String p1 ,String p2) {
//		BiFunction<String,String,Boolean> f = String :: equals;
//		BiPredicate<String, String> p = (p1,p2)-> p1.equals(p2); 메서드 참조하면 아래와 같이 됨 !!
		BiPredicate<String, String> p = String :: equals;
		return p.test(p1,p2);
	}
	public int random(int a, int b) {
//		printer.accept("ctrl에서 넘어온 파라미터 값 :"+a +','+ b );
		BiFunction<Integer, Integer, Integer> f = (t,u) -> (int) (Math.random()*(u-t))+t;
		f.apply(a,b);
		return f.apply(a,b); 
	}
	public int[] intArray(int size) {
//		Function<Integer,int[]> f = t -> new int[t]; --> 메서드만 참조하면 아래와 같이 해줄 수 있음!!
		Function<Integer,int[]> f = int[]::new;
		return f.apply(size);
	}
	public String currentDate() {
		return  new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public String currendTime() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	}
}


 