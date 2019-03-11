package com.przemo.dao;

import java.util.List;

import com.przemo.entity.Film;
import com.przemo.entity.TempFilm;

public interface FilmDao 
{
	public void saveFilm(Film film);
	
	public List<Film> getAllFilms();

	public Film getFilmById(int filmId);

	public void deleteFilmById(int filmId);
	
	public void updateFilm(Film film);
	
	public List<TempFilm> getAllTempFilm();
	
	public void deleteTempFilmById(int tempFilmId);
	
	public void addTempFilmToMainDB(Film tempFilm);

}
