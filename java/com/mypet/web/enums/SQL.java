package com.mypet.web.enums;

public enum SQL {
	CREATE_USER, DROP_USER,CREATE_DB,CREATE_ADMIN;
	
	@Override
	public String toString() {
		String result = "";
		switch (this) {
//		private String uid,pwd,ssn,uname,phone,address,email,petType;
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
//			aid,pwd,ssn,pname,phone,address,email
			result = "CREATE TABLE ADMIN("
					+ "AID VARCHAR(30) PRIMARY KEY,"
					+ "PWD VARCHAR(30),"
					+ "SSN VARCHAR(30),"
					+ "ANAME VARCHAR(30),"
					+ "PHONE VARCHAR(30),"
					+ "EMAIL VARCHAR(30),"
					+ "ADDRESS VARCHAR(30))";
			break;
		}
		return result;
	}
	
}
