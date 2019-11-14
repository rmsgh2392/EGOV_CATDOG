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
	        List<String> pet = Arrays.asList(
	        				"마스티프","로트바일러","복서","자이언트 슈나우저","스탠더드슈나우저","도베르만 핀셔","그레이트데인",
	        				"불마스티프","저먼 셰퍼드","코몬도르","그레이트 피레니즈","콜리","캉갈","올드 잉글리시 시프도그",
	        				"풀리","셰틀랜드 시프도그","비어디드 콜리","웰시 코기","티베탄마스티프","사모예드견","시베리안허스키",
	        				"알래스칸 맬러뮤트","그린란드견","세인트 버나드","부비에 데 플랑드르","뉴펀들랜드","아프간 하운드",
	        				"그레이하운드","스코티시 디어하운드","아이리시 울프하운드","휘핏","보르조이","살루키","아자와크",
	        				"닥스훈트","블러드하운드","잉글리시 폭스하운드","바셋하운드","해리어","비글","바센지",
	        				"로디지안 리지백","파라오 하운드  ","비즐라","잉글리시포인터","골든리트리버","래브라도리트리버",
	        				"체서피크 베이 리트리버","컬리 코티드 리트리버","플랫 코티드 리트리버","아이리시 세터",
	        				"아이리시 워터 스패니얼","아메리칸 코커 스패니얼","브리트니","웰시 스프링어 스패니얼",
	        				"잉글리시 스프링어 스패니얼","잉글리시 코커 스패니얼","폭스 테리어","맨체스터 테리어","베들링턴 테리어",
	        				"불 테리어","웰시 테리어","아이리시 테리어","웨스트 하일랜드 화이트 테리어","스태퍼드셔 불 테리어",
	        				"댄디 딘몬트 테리어","미니어처 슈나우저","스카치 테리어","에어데일 테리어","잭 러셀 테리어","핏불 테리어",
	        				"라사 압소","프렌치 불도그","보스턴 테리어","스키퍼키","불도그","비숑 프리제","일본 스피츠","차우차우",
	        				"달마티안","스탠더드 푸들","미니어처푸들","도사견","시바견","아키타견","동경이","불개","삽살개",
	        				"제주개","진돗개","통일개","풍산개","친","말티즈","파피용","차이니스크레스티드","이탈리안 그레이하운드",
	        				"퍼그","미니어처 핀셔","페키니즈","포메라니안","아펜핀셔","토이 푸들","시추","치와와",
	        				"요크셔 테리어","실키 테리어","독일 스피츠","카발리에 킹 찰스 스패니얼","킹 찰스 스패니얼");
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
