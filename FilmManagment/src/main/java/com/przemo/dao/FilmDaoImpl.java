package com.przemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.przemo.entity.Admin;
import com.przemo.entity.Aktor;
import com.przemo.entity.Film;
import com.przemo.entity.TempFilm;

@Repository
public class FilmDaoImpl implements FilmDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveFilm(Film film)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(film);	
	}

	@Override
	public List<Film> getAllFilms() 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from Film");
		
		List<Film> allfilms= query.list();
		
		return allfilms;	
	}

	@Override
	public Film getFilmById(int filmId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
		return currentSession.get(Film.class, filmId);
	}

	@Override
	public void deleteFilmById(int filmId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		Film film = currentSession.get(Film.class, filmId);
		
		currentSession.delete(film);
	}

	@Override
	public void updateFilm(Film film) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.update(film);
		
	}

	@Override
	public List<TempFilm> getAllTempFilm() 
	{
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("from TempFilm");
		
		List<TempFilm> allTempfilms= query.list();
		
		return allTempfilms;	
	}

	@Override
	public void deleteTempFilmById(int tempFilmId)
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		TempFilm tempFilm = currentSession.get(TempFilm.class, tempFilmId);
		
		currentSession.delete(tempFilm);
	}

	@Override
	public void addTempFilmToMainDB(Film tempFilm) 
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(tempFilm);
	}

	@Override
	public void deleteActorFromFilmById(int actorId, int filmId) 
	{
		Film film = getFilmById(filmId);
		
		for(Aktor aktor: film.getAktorzyList())
		{
			if(aktor.getAktorzy_id()==actorId)
			{
				film.getAktorzyList().remove(aktor);
				break;
			}
		}
		
		updateFilm(film);
	}

	@Override
	public List<Film> getAllOrderedFilms()
	{
		Session currentSession = sessionFactory.getCurrentSession();
		
		String hql = "FROM Film WHERE dostepnosc='false' AND zamowione='false'"; //and zamowione = false

		Query query = currentSession.createQuery(hql);
		List<Film> results = query.list();
		
		return results;
	}
	
	
	
}
