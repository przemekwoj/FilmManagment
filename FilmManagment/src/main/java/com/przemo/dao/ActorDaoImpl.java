package com.przemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.przemo.entity.Aktor;
import com.przemo.entity.Film;
import com.przemo.service.DatabaseService;

@Repository
public class ActorDaoImpl implements ActorDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Aktor getActorById(int actorId) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Aktor.class, actorId);
	}

	@Override
	public void saveActor(Aktor actor)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(actor);
		
	}

	@Override
	public void updateActor(Aktor aktor)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(aktor);
		
	}

	@Override
	public List<Aktor> getAllActors() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from Aktor");
		
		List<Aktor> allactors= query.list();
		
		return allactors;
	}

	

}
