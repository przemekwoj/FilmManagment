package com.przemo.service;

import java.util.List;

import com.przemo.entity.Admin;
import com.przemo.entity.NormalUser;
import com.przemo.entity.abst.User;

public interface DatabaseService 
{
	public List<User> getAllUsers();
	
	public List<Admin> getAllAdmins();
	
	public List<NormalUser> getAllNormalUsers();
	
	public void saveAdmin(Admin admin);
	
	public void saveNormalUser(NormalUser normalUser);
}
