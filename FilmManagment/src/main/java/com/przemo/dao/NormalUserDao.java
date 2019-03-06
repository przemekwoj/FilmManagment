package com.przemo.dao;

import java.util.List;

import com.przemo.entity.NormalUser;


public interface NormalUserDao
{
	public List<NormalUser> getAllNormalUsers();
	
	public void saveNormalUser(NormalUser normalUser);

}
