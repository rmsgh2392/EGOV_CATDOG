package com.mypet.web.enums;

public enum SQL {
	CREATE_CUSTOMER, DROP_CUSTOMER,CREATE_ARTICLES, CREATE_DB;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case CREATE_DB :
			result = "CREATE DATABASE MYPETDB";
			break;
		case CREATE_CUSTOMER:
			result = "CREATE TABLE MYSQL.CUSTOMER";
			break;
		case DROP_CUSTOMER :
			result = "DROP TABLE MYSQL.CUSTOMER";
			break; 
		case CREATE_ARTICLES :
			result = "CREATE TABLE ARTICLES("
					+ "ARTICLESEQ VARCHAR(30),"
					+ "IMAGE VARCHAR(30),"
					+ "UID VARCHAR(30) PRIMARY KEY,"
					+ "COMMENTS VARCHAR(30),"
					+ "MSG VARCHAR(30),"
					+ "RATING VARCHAR(30),"
					+ "BOARDTYPE VARCHAR(30),"
					+ "TITLE VARCHAR(30),"
					+ "CONTENT VARCHAR(30))";
			break;
		}
		return result;
	}
}
