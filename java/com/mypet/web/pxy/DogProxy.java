package com.mypet.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.aop.TxMapper;
import com.mypet.web.dog.Dog;

@Component
public class DogProxy {
	@Autowired TxMapper txMapper;
	@Autowired Box<String> box; 
	 public List<String> makeSpecies() {
	        List<String> pet = Arrays.asList
	        		("포메라이안","비숑프리제","스피츠","푸들","치와와","닥스훈트",
	                "말티즈","시츄","요크셔테리어","특수견","시바견","웰시코기","프렌치불독",
	                "비글","골든리트리버","레브라도리트리버","시베리안 허스키","보더콜리",
	                "사모예드","버니즈마운틴","잉글리쉬불독","알레스카 말라뮤트");
	        return pet; 
	    }
	    public String makePetSize() {
	        List<String> petSizes = Arrays.asList("소형견", "중형견", "대형견");
	        Collections.shuffle(petSizes);
	        String size = petSizes.get(0);
	        return size;
	    }
	    public String makeName(){
	        List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
	                "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
	                "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
	                "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
	                "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");
	            List<String> lname = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
	                "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
	                "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
	                "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
	                "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
	                "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
	                "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
	                "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
	                "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
	                "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
	            Collections.shuffle(fname);
	            Collections.shuffle(lname);
	            String name = fname.get(0)+lname.get(0);
	            return name;
	    }
	    
	    public String makeSex() {
	        List<String> gender = Arrays.asList("수컷", "암컷");
	        Collections.shuffle(gender);
	        String sex = gender.get(0);
	        return sex;
	    }
	    public String makeHairLength() {
	        List<String> hairLengths = Arrays.asList("단모종", "장모종");
	        Collections.shuffle(hairLengths);
	        String hairLength = hairLengths.get(0);
	        return hairLength;
	    }
	    public String makeColor() {
	        List<String> colors = Arrays.asList("갈색", "흰색", "검정색","잡색");
	        Collections.shuffle(colors);
	        String color = colors.get(0);
	        return color;
	    }
	    public String breed() {
	        List<String> breeds = Arrays.asList("임신", "홀몸");
	        Collections.shuffle(breeds);
	        String breed = breeds.get(0);
	        return breed;
	    }
	    public String makeVaccins() {
	        List<String> vaccins = Arrays.asList("1차 접종", "2차 접종","3차 접종");
	        Collections.shuffle(vaccins);
	        String vaccin = vaccins.get(0);
	        return vaccin;
	    }
	    
	    public String birthDate() {
	        int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	        int iMinMonth = 1;
	        int iMaxMonth = 12;
	        int iRandomMonth = (int) (Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
	        int iRandomDay = (int) (Math.random() * (maxDays[iRandomMonth - 1] - 2) + 1);
	        
	        String birth_date = String.format("%d월 %d일",iRandomMonth, iRandomDay);
	        return birth_date;
	    }
	    public String makeAge() {
	        int age1 = (int) (Math.random() * 9);
	        String age = String.format("%d살",age1);
	        return age;
	    }
	   
	    @Transactional
	    public void insertDogs() {
	    	for(String x : makeSpecies()) {
	    		txMapper.insertDogs(new Dog(
	    		    	x,makePetSize(),makeName(),
	    		    	makeSex(),makeHairLength(),makeColor(),
	    		    	breed(),makeVaccins(),birthDate(),makeAge()));
	    	}
	    }
	    
	
	
}
