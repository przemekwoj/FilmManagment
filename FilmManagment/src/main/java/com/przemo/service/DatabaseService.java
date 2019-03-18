package com.przemo.service;

import java.util.List;

import com.przemo.entity.Admin;
import com.przemo.entity.Aktor;
import com.przemo.entity.Film;
import com.przemo.entity.NormalUser;
import com.przemo.entity.TempFilm;
import com.przemo.entity.abst.User;

public interface DatabaseService 
{
	public List<User> getAllUsers();
	
	public List<Admin> getAllAdmins();
	
	public List<NormalUser> getAllNormalUsers();
	
	public List<Film> getAllFilms();
	
	public List<Aktor> getAllActors();
	
	public void saveAdmin(Admin admin);
	
	public void saveActor(Aktor actor);
	
	public void saveNormalUser(NormalUser normalUser);
	
	public void saveFilm(Film film);
	
	public void saveTempFilm(TempFilm film);

	public TempFilm getTempFilm(int tempFilmId);
	
	public Film getFilmById(int filmId);
	
	public User getUserById(int userId);
	
	public Admin geAdminById(int adminId);

	public NormalUser getNormalUseryId(int normalUserId);

	public void deleteFilmById(int filmId);
	
	public void deleteActorFromFilmById(int actorId,int filmId);
	
	public void updateFilm(Film film);
	
	public void updateActor(Aktor aktor);
	
	public void updateUser(User user);
	
	public List<TempFilm> getAllTempFilm();
	
	public void deleteTempFilmById(int tempFilmId);
	
	public void addTempFilmToMainDB(Film tempFilm);
	
	public Aktor getActorById(int actorId);


}
