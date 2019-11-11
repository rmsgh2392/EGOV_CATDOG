package com.maypet.web.enums;

public enum Sql {
	CREAT_USER,CREAT_DB,DROP_USER,CREATE_ADMIN,CREATE_DOG,DROP_DOG;
	@Override
	public String toString() {
		String result="";
		switch(this) {
		case CREAT_DB: 
			result = "CREATE DATABASE MYPETDB";
			break;
		case CREAT_USER: 
			result = "CREATE TABLE MYSQL.USER()";
			break;
		case DROP_USER:
			result="DROP TABLE MYSQL.USER";
			break;
		case CREATE_ADMIN:
			result="DROP TABLE MYSQL.USER";
			break;
		case CREATE_DOG:
			result= "CREATE TABLE DOG("
					+ "SPECIES VARCHAR(10) PRIMARY KEY,"
					+ "SIZE VARCHAR(10),"
					+ "NAME VARCHAR(10),"
					+ "HAIR_LENGTH VARCHAR(10),"
					+ "COLOR VARCHAR(10),"
					+ "SEX VARCHAR(10),"
					+ "BREED VARCHAR(10),"
					+ "AGE VARCHAR(10),"
					+ "BIRTH_DATE VARCHAR(10),"
					+ "VACCIN VARCHAR(10))";
			break;
		case DROP_DOG:
			result="DROP TABLE DOG";
		}

		return result;
	}
}
