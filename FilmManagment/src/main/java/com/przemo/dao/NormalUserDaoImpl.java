package com.przemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.przemo.entity.Admin;
import com.przemo.entity.NormalUser;
import com.przemo.entity.TempFilm;

@Repository
public class NormalUserDaoImpl  implements NormalUserDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<NormalUser> getAllNormalUsers() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "FROM User user WHERE roleType = 'normalUser'";
		Query query = currentSession.createQuery(hql);
		List<NormalUser> results = query.list();
		
		return results;
	}

	@Override
	public void saveNormalUser(NormalUser normalUser) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(normalUser);		
	}

	@Override
	public NormalUser getNormalUseryId(int normalUserId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		return currentSession.get(NormalUser.class, normalUserId);	

	}
}
