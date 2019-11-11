package com.mypet.web.user;


import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public void insertUser(User param);
	public User selectUserById(User param);
	public int existId(String uid);
	public int lastCNum();
	public int countUsers();
	public void create_user(HashMap<String, String> paramMap);
	public void createDB(HashMap<String, String> paramMap);
	public void dropUser(HashMap<String, String> paramMap);
	public void create_dogs(HashMap<String, String> paramMap);
	public void delete_dogs(HashMap<String, String> paramMap);
}
