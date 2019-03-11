package com.przemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.przemo.entity.Film;
import com.przemo.entity.TempFilm;

@Repository
public class TempFilmDaoImpl implements TempFilmDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTempFilm(TempFilm film) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(film);	
	}

	@Override
	public TempFilm getTempFilm(int tempFilmId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		return currentSession.get(TempFilm.class, tempFilmId);	
	}

}
