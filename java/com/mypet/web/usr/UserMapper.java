package com.mypet.web.usr;

import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper {
	public void insertUser(User user);
	public User selectByIdPw(User user);
	public User findById(User user);
	public User updateUser(User user);
	public User deleteUser(User user);
	public int existId(String uid);
}
