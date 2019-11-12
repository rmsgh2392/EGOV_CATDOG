package com.mypet.web.enums;

public enum SQL {
	CREATE_USER, DROP_USER,CREATE_DB,CREATE_ADMIN,CREATE_CAT,DROP_CAT,TRUNCATE_USER,CREATE_ARTICLES;
	@Override
	public String toString() {
		String result = "";
		switch (this) {
		case CREATE_USER:
			result = "CREATE TABLE USER("
					+ "UID VARCHAR(30) PRIMARY KEY,"
					+ "PWD VARCHAR(30),"
					+ "UNAME VARCHAR(30),"
					+ "SSN VARCHAR(30),"
					+ "PHONE VARCHAR(30),"
					+ "ADDRESS VARCHAR(30),"
					+ "EMAIL VARCHAR(30),"
					+ "PETTYPE VARCHAR(30))";
			break;
		case DROP_USER:
			result = "DROP TABLE USER";
			break;
		case CREATE_DB:
			result= "CREATE DATABASE MYPET";
			break;
		case CREATE_ADMIN:
			result = "CREATE TABLE ADMIN("
					+ "AID VARCHAR(30) PRIMARY KEY,"
					+ "PWD VARCHAR(30),"
					+ "SSN VARCHAR(30),"
					+ "ANAME VARCHAR(30),"
					+ "PHONE VARCHAR(30),"
					+ "EMAIL VARCHAR(30),"
					+ "ADDRESS VARCHAR(30))";
			break;
		case CREATE_CAT :
			result = "CREATE TABLE CAT("
					+ "BIRTH DATE,"
					+ "SEX VARCHAR(6),"
					+ "NAME VARCHAR(21),"
					+ "HAIRLENGTH VARCHAR(6),"
					+ "HAIRCOLOR VARCHAR(9),"
					+ "SPECIES VARCHAR(30),"
					+ "SIZE VARCHAR(9),"
					+ "STYLE VARCHAR(21),"
					+ "ILLHISTORY VARCHAR(60))";
			break;
		case DROP_CAT :
			result = "DROP TABLE CAT";
			break;
		case TRUNCATE_USER :
			result = "TRUNCATE TABLE USER";
			break;
		case CREATE_ARTICLES:
//			articleseq, image , uid, comments, msg, rating, boardType, title, content ;
			result = "CREATE TABLE ARTICLES("
					+ "ARTICLESEQ INT auto_increment PRIMARY KEY,"
					+ "IMAGE VARCHAR(6),"
					+ "UID VARCHAR(21),"
					+ "COMMENTS VARCHAR(6),"
					+ "MSG VARCHAR(9),"
					+ "RATING VARCHAR(30),"
					+ "boardType VARCHAR(9),"
					+ "TITLE VARCHAR(21),"
					+ "CONTENT VARCHAR(60)"
					+ "foreign key(UID) references USER(UID))";
		}
		return result;
	}
}
