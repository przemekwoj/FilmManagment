package com.przemo.dao;

import com.przemo.entity.Film;
import com.przemo.entity.TempFilm;

public interface TempFilmDao 
{
	public void saveTempFilm(TempFilm film);

	public TempFilm getTempFilm(int tempFilmId);
}
