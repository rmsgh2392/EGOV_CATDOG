package com.mypet.web.pxy;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;
@Data
@Lazy
@Component
public class Box<T> {
	private ArrayList<T> list;
	public void add(T item) {
		list = new ArrayList<T>();
		list.add(item);
	}
	public T get(int i) {return list.get(i);}
	public ArrayList<T> getList() {return list;}
	public int size() {return list.size();}
	public String toString() {return list.toString();}
	public void clear() {list.clear();}
	/*public void accept(List<String> x, List<?> y) {
		map = new HashMap<>();
		for(int i=0; i < x.size(); i++) {
			map.put(x.get(i), y.get(i));
		}
		map.forEach((k,v)-> System.out.println(String.format("%s : %s",k,v)));
		//내부적으로 consumer 인터페이스가 작동 accept()메서드를 가지고 있음 
	}
	public HashMap<String, Object> get(){
		return map;
	}*/
	
}
/*public class ProxyMap {
	private HashMap<String,Object> map;
	public void accept(List<String> x,List<?> y) {
		map = new HashMap<>();
		for(int i = 0; i < x.size(); i++) {
			map.put(x.get(i),y.get(i));
		}
		map.forEach((k,v) -> System.out.print(String.format("%s:/%s", k,v)));
		


public class ProxyMap {
	private HashMap<String, Object> map;
	public void accept(List<String> x, List<?> y) {
		map = new HashMap<>();
		for(int i =0; i <x.size(); i++) {
			map.put(x.get(i), y.get(i));
		}
		map.forEach((k,v)-> System.out.print(String.format("%s : %s", k, v)));

	}
	public HashMap<String, Object> get() {
		return map;
	}*/






