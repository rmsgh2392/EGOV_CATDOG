package com.mypet.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mypet.web.aop.TxMapper;
import com.mypet.web.cat.Cat;

@Component
public class CatProxy extends Proxy{
	@Autowired TxMapper txMapper;

	public String setBirth() {
		int[] maxDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int iMinMonth = 1;
        int iMaxMonth = 12;
        int iRandomMonth = (int) (Math.random() * iMaxMonth - iMinMonth + 1) + iMinMonth;
        int iRandomDay = (int) (Math.random() * (maxDays[iRandomMonth - 1] - 2) + 1);
        
        String birth_date = String.format("%d월 %d일",iRandomMonth, iRandomDay);
        return birth_date;
	}
	public String setSex() {
		List<String> sex = Arrays.asList("male","female","neuter");
		Collections.shuffle(sex);
		String sexType = sex.get(0);
		return sexType;
	}
	public String setName() {
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
	        String fullname = fname.get(0)+lname.get(0);
	         
		return fullname;
	}
	public String setHairlength() {
		
		List<String> hairlength = Arrays.asList("short","medium","long ");
		Collections.shuffle(hairlength);
		String cathair = hairlength.get(0);
		return cathair;
	}
	public String setHaircolor() {
		List<String> haircolor = Arrays.asList("빨간색","다홍색","주황색","귤색","노란색","연두색","초록색","청록색","하늘색","파란색","남색","보라색","자주색","분홍색","흰색","회색","검은색","갈색","금색","은색");
		Collections.shuffle(haircolor);
		String catcolor = haircolor.get(0);
		return catcolor;
	}
	public String setSpecies() {
		List<String> pet = 
		Arrays.asList("데본 렉스","돈스코이","라이코이","래펌 쇼트헤어","러시안 블루","맨덜레이","맹크스","먼치킨","메콩 밥테일",
		"봄베이","미뉴엣","민스킨","벵갈","버미즈","버밀라","브라질리안쇼트헤어","브리티시 쇼트헤어","사바나캣","샤트룩스","샴",
		"세렝게티","셀커크 렉스","셀틱 쇼트헤어","소코케","스노우슈","스코티시스트레이트","스코티시폴드","스핑크스","실론","싱가퓨라",
		"아나톨리","아리비안 마우","아메리칸 밥테일 쇼트헤어","아메리칸 쇼트헤어","아메리칸 와이어헤어","아메리칸 컬","아비시니안",
		"아프로디테","엑소틱쇼트헤어","오리엔탈","오스트렐리안미스트","오시캣","오호스아줄레스쇼트헤어","우랄렉스","이집션마우","재패니즈밥테일쇼트헤어",
		"저먼렉스","차이니즈리허","카오매니","카렐리안밥테일쇼트헤어","칸나이","컬러포인트쇼트헤어","코니시렉스","코렛","코시","쿠릴리안밥테일",
		"클래시캣","타이","토이거","통키니즈","피터발드","픽시밥","하바나브라운","하이랜더쇼트헤어","코리안쇼트헤어","노르웨이숲",
		"니벨룽","도이치랭하","래그돌-라가머핀","래펌롱헤어","먼치킨롱헤어","메인쿤","미뉴엣롱헤어","발리니즈","버만","버밀라롱헤어","벵갈롱헤어",
	    "브리티시롱헤어","셀커크렉스롱헤어","소말리","스코티시스트레이트롱헤어","시베리안포레스트-네바마스커레이드-모스크바롱헤어",
		"심릭","아메리칸밥테일롱헤어","아메리칸컬롱헤어","아프로디테롱헤어","오리엔탈롱헤어","오호스아줄레스롱헤어","요크",
		"우랄렉스롱헤어","재패니즈밥테일롱헤어","카렐리안밥테일롱헤어","쿠릴리안밥테일롱헤어","터키시앙고라","터키시반",
		"티파니","페르시안-페르시안친칠라","히말라얀","픽시밥롱헤어","하이랜더","하이랜드폴드");
		Collections.shuffle(pet);
		String species = pet.get(0);
		return species;
	}
	public String setSize() {
		List<String> size = Arrays.asList("small","medium","large ");
		Collections.shuffle(size);
		String sizeType = size.get(0);
		return sizeType;
	}
	public String setStyle() {
		return null;
	}
	public String setIllhistory() {
		List<String> illhistory = Arrays.asList("피부질환","감기","안구질환","고열","구토","설사","식욕부진","소화기질환","근육통","오한","가래","골절","타박상","진드기","식중독","기타","없음");
		Collections.shuffle(illhistory);
		String sick = illhistory.get(0);
		return sick;
	}
	public Cat makeCats() {
		return new Cat(
		setBirth(),
		setSex(),
		setName(),
		setHairlength(),
		setHaircolor(),
		setSpecies(),
		setSize(),
		setStyle(),
		setIllhistory());
	}
	@Transactional
	public void insertCats() {
		for(int i=0;i<100;i++) {
			txMapper.insertCats(makeCats());
		}
	}
	
}
