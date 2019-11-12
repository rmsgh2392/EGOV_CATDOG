package com.mypet.web.enums;

public enum Path {
	UPLOAD_PATH;
	
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case UPLOAD_PATH:
			result =
			"C:\\Users\\rmsgh2392\\workspace\\eGovFrame-3.8\\workspace\\mypet\\src\\main\\webapp\\resources\\upload\\temp";
		}
		return result;
	}
}
