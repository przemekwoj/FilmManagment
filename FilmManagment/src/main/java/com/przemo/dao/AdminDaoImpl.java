package com.przemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.przemo.entity.Admin;

@Repository
public class AdminDaoImpl implements AdminDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveAdmin(Admin admin) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		//String hql = "FROM User user WHERE user.roleType = 'admin'";
		String hql = "FROM User WHERE roleType='admin'";

		Query query = currentSession.createQuery(hql);
		List<Admin> results = query.list();
		
		return results;
	}

	@Override
	public Admin getAdminById(int adminId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Admin.class, adminId);
	}
	
}
