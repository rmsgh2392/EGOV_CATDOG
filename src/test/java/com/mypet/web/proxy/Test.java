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
		char c = (char) ((Math.random()*26)+97);
		System.out.println(String.format("%4s@%5s com",c,c));
		List<String> pet = Arrays.asList("포메라이안","비숑프리제","스피츠","푸들","치와와","닥스훈트",
				"말티즈","시츄","요크셔테리어","특수견","시바견","웰시코기","프렌치불독",
				"비글","골든리트리버","레브라도리트리버","시베리안 허스키","보더콜리",
				"사모예드","버니즈마운틴","잉글리쉬불독","알레스카 말라뮤트");
		Collections.shuffle(pet);
		String pettype = pet.get(0);
		System.out.println(pettype);
		
		List<String> city = Arrays.asList("서울특별시", "부산광역시", "인천광역시", "대구광역시", "대전광역시", "광주광역시", "울산광역시", "제주특별자치도", "세종특별자치시",
		"경기도", "충청북도", "충청남도", "강원도", "전라북도", "전라남도", "경상북도", "경상남도");
		List<String> seoulState = Arrays.asList("강서구", "양천구", "구로구", "은평구", "마포구", "영등포구", "서대문구", "동작구", "관악구", "용산구", "종로구", "중구", "서초구", "강남구", "성동구", "성북구", "동대문구", "강북구", "도봉구", "노원구", "중랑구", "광진구", "송파구", "강동구");
		List<String> busanState = Arrays.asList("기장군", "금정구", "북구", "동래구", "해운대구", "연제구", "수영구", "남구", "부산진구", "사상구", "동구", "서구", "중구", "영도구", "사하구", "강서구");
		List<String> incheonState = Arrays.asList("중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군");
		List<String> daeguState = Arrays.asList("달성군", "달서구", "서구", "북구", "중구", "남구", "동구", "수성구");
		List<String> daejeonState = Arrays.asList("대덕구", "유성구", "서구", "중구", "동구");
		List<String> gwangjuState = Arrays.asList("광산구", "북구", "서구", "동구", "남구");
		List<String> ulsanState = Arrays.asList("울주군", "북구", "중구", "남구", "동구");
		List<String> jejuState = Arrays.asList("제주시", "서귀포시");
		List<String> sejongState = Arrays.asList("조치원읍", "연기면", "연동면", "부강면", "금남면", "장군면", "연서면", "전의면", "전동면", "소정면", "한솔동", "새롬동", "도담동", "아름동", "종촌동", "고운동", "소담동", "보람동", "대평동");
		List<String> geunggiState = Arrays.asList("수원시", "고양시", "용인시", "성남시", "부천시", "안산시", "화성시", "남양주시", "안양시", "평탱시", "시흥시", "파주시", "의정부시", "김포시", "광주시", "광명시", "군포시", "오산시", "하남시", "이천시", "양주시", "안성시", "구리시", "포천시", "의왕시", "여주시", "양평군", "동두천시", "가평군", "과천시", "연천군");
		Collections.shuffle(city);
		Collections.shuffle(seoulState);
		Collections.shuffle(busanState);
		Collections.shuffle(incheonState);
		Collections.shuffle(daeguState);
		Collections.shuffle(daejeonState);
		Collections.shuffle(gwangjuState);
		Collections.shuffle(ulsanState);
		Collections.shuffle(jejuState);
		Collections.shuffle(sejongState);
		Collections.shuffle(geunggiState);
		String result = city.get(0) + seoulState.get(0) + geunggiState.get(1);
		System.out.println(result);

		
	}
}
