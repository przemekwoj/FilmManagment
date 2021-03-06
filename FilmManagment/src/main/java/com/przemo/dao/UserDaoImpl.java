package com.przemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.przemo.entity.TempFilm;
import com.przemo.entity.abst.User;

@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getAllUsers() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from User");
		
		List<User> allusers= query.list();
		
		return allusers;
	}

	@Override
	public User getUserById(int userId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		return currentSession.get(User.class, userId);	
	}

	@Override
	public void updateUser(User user) 
	{
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.update(user);
	}

}
