package com.mypet.web.enums;

public enum Path {
	UPLOAD_PATH, CRAWLING_TARGET;
	
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case UPLOAD_PATH:
			result =
//			String.format("C:%sUsersrmsgh2392\\workspace\\eGovFrame-3.8\\workspace\\mypet\\src\\main\\webapp\\resources\\upload\\temp", args)
			"C:\\Users\\rmsgh2392\\workspace\\eGovFrame-3.8\\workspace\\mypet\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		case CRAWLING_TARGET:
			result = "https://store.naver.com/accommodations/detail?entry=plt&id=1285629759&tab=bookingReview&tabPage=0";
			break;
		}
		return result;
	}
}
