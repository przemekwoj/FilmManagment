package com.przemo.dao;

import java.util.List;

import com.przemo.entity.abst.User;

public interface UserDao
{
	public List<User> getAllUsers();
	
	public User getUserById(int userId);
	
	public void updateUser(User user);


}
