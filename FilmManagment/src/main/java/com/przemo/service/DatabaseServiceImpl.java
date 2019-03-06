package com.przemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.przemo.dao.AdminDao;
import com.przemo.dao.NormalUserDao;
import com.przemo.dao.UserDao;
import com.przemo.entity.Admin;
import com.przemo.entity.NormalUser;
import com.przemo.entity.abst.User;

@Service
public class DatabaseServiceImpl implements DatabaseService
{
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private NormalUserDao normalUserDao;

	@Override
	public List<User> getAllUsers()
	{
		return  userDao.getAllUsers();
	}

	@Override
	public void saveAdmin(Admin admin)
	{
		adminDao.saveAdmin(admin);
	}

	@Override
	public List<Admin> getAllAdmins()
	{
		return adminDao.getAllAdmins();
	}

	@Override
	public List<NormalUser> getAllNormalUsers() 
	{
		return normalUserDao.getAllNormalUsers();
	}

	@Override
	public void saveNormalUser(NormalUser normalUser) 
	{
		normalUserDao.saveNormalUser(normalUser);
	}

}
