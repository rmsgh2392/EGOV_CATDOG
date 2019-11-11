package com.mypet.web.proxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
	
		List<String> idE = 
		Arrays.asList("a","b","c","d","e","f","g"
		,"h","i","j","k","l","n","m","o","p"
		,"q","r","s","t","u","v","w","x","y","z",
		"A","B","C","D","E","F","G",
		"H","I","J","K","L","N","M","O","P"
		,"Q","R","S","T","U","V","W","X","Y","Z",
		"0","1","2","3","4","5","6","7","8","9");
		Collections.shuffle(idE);
		System.out.println(idE.size());
		String fullId = idE.get(0) + idE.get(1)+idE.get(2)+idE.get(3)+idE.get(4);
		System.out.println(fullId);
		/*int a,b =0;
		int temp = (int)(Math.random()*b)+a;*/
		System.out.println(String.format("03%d-%4d-%4d",
				(int)(Math.random()*10)+1,
				(int)(Math.random()*9999),
				(int)(Math.random()*9999)));
	}
}
