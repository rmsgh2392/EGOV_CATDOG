package com.mypet.web.pxy;

import java.io.File;
import java.util.HashMap;
import java.util.function.BiFunction;

import org.springframework.stereotype.Component;
@Component("genfile")
public class GenFile<T> {
	private File file;
	
	public File makeFile(T t , String t1) {
		HashMap<String, T> h = new HashMap<>();
		h.put("T", t);
		
		if(h.get("T") instanceof String) {
			file = new File((String)h.get("T"),t1);
		}else if (h.get("T") instanceof File) {
			System.out.println(">>>" +(File)h.get("T"));
			file = new File((File)h.get("T"),t1);
		}
		return file;
	}
	/*File uploadPath = new GenFile<String>().makeFile(uploadFoler,getFolder());
	File savedFile = new GenFile<File>().makeFile(uploadPath,"");*/
	
	
	//  public File makeDir(String t, String u) {
	//  BiFunction<String, String, File> f = File::new;
	//  return f.apply(t, u);
	//}
	//public File makeFile(File t,String u) {
	//  BiFunction<File, String, File> f = File::new;
	//  return f.apply(t, u);
	//}
}
