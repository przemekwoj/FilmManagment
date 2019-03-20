package com.przemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.przemo.dao.ActorDao;
import com.przemo.dao.AdminDao;
import com.przemo.dao.FilmDao;
import com.przemo.dao.NormalUserDao;
import com.przemo.dao.TempFilmDao;
import com.przemo.dao.UserDao;
import com.przemo.entity.Admin;
import com.przemo.entity.Aktor;
import com.przemo.entity.Film;
import com.przemo.entity.NormalUser;
import com.przemo.entity.TempFilm;
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
	
	@Autowired
	private FilmDao filmDao;
	
	@Autowired 
	private TempFilmDao tempFilmDao;
	
	@Autowired 
	private ActorDao actorDao;

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

	@Override
	public void saveFilm(Film film) 
	{
		filmDao.saveFilm(film);
	}

	@Override
	public List<Film> getAllFilms() 
	{
		return filmDao.getAllFilms();
	}

	@Override
	public Film getFilmById(int filmId) 
	{
		return filmDao.getFilmById(filmId);
	}

	@Override
	public void saveTempFilm(TempFilm film)
	{
		tempFilmDao.saveTempFilm(film);
	}

	@Override
	public TempFilm getTempFilm(int tempFilmId)
	{
		return tempFilmDao.getTempFilm(tempFilmId);
	}

	@Override
	public void deleteFilmById(int filmId) 
	{
		filmDao.deleteFilmById(filmId);
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}

	@Override
	public Admin geAdminById(int adminId) {
		// TODO Auto-generated method stub
		return adminDao.getAdminById(adminId);
	}

	@Override
	public NormalUser getNormalUseryId(int normalUserId) {
		// TODO Auto-generated method stub
		return normalUserDao.getNormalUseryId(normalUserId);
	}

	@Override
	public void updateFilm(Film film)
	{
		filmDao.updateFilm(film);
	}

	@Override
	public void updateUser(User user) 
	{
		userDao.updateUser(user);
	}

	@Override
	public List<TempFilm> getAllTempFilm()
	{
		return filmDao.getAllTempFilm();
	}

	@Override
	public void deleteTempFilmById(int tempFilmId) 
	{
		filmDao.deleteTempFilmById(tempFilmId);
	}

	@Override
	public void addTempFilmToMainDB(Film tempFilm) 
	{
		filmDao.addTempFilmToMainDB(tempFilm);
	}

	@Override
	public Aktor getActorById(int actorId)
	{
		return actorDao.getActorById(actorId);
	}

	@Override
	public void saveActor(Aktor actor)
	{
		actorDao.saveActor(actor);
	}

	@Override
	public void updateActor(Aktor aktor)
	{
		actorDao.updateActor(aktor);
	}

	@Override
	public List<Aktor> getAllActors() 
	{
		return actorDao.getAllActors();
	}

	@Override
	public void deleteActorFromFilmById(int actorId, int filmId)
	{
		filmDao.deleteActorFromFilmById(actorId, filmId);
	}

	@Override
	public List<Film> getAllOrderedFilms() 
	{
		return filmDao.getAllOrderedFilms();
	}

}
