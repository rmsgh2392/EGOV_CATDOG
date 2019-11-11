package mypet;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		//실행시 ???개 쿠폰 생성
	   	  int emailSize = 50;

	   	  final char[] possibleCharacters =
	   	    {'1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f',
	   	     'g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v',
	   	     'w','x','y','z'};
	   	  
	   	  final int possibleCharacterCount = possibleCharacters.length;
	   	  String[] arr = new String[emailSize];
	   	  Random rnd = new Random();
	   	  int currentIndex = 0;
	   	  int i = 0;
	   	  while (currentIndex < emailSize) {
	   	   StringBuffer buf = new StringBuffer(16);
	   	   //i는 8자리의 랜덤값을 의미
	   	   for (i= 6; i > 0; i--) {
	   	    buf.append(possibleCharacters[rnd.nextInt(possibleCharacterCount)]);
	   	   }
	   	   String email = buf.toString();
	   	   System.out.println("이메일주소==>"+email+"@gmail.com");   
	   	   arr[currentIndex] = email+"@gmail.com";
	   	   currentIndex++; 	   
	   	   
	   	   
	   	  }
	}

}
