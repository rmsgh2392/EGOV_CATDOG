package com.mypet.web.usr;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	public void insertUser(User param);
	public User selectUserById(User param);
	public int existId(String uid);
}
