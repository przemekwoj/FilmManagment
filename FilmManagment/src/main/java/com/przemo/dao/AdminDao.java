package com.przemo.dao;

import java.util.List;

import com.przemo.entity.Admin;

public interface AdminDao 
{
	public List<Admin> getAllAdmins();
	
	public void saveAdmin(Admin admin);
	
	public Admin getAdminById(int adminId);


}
