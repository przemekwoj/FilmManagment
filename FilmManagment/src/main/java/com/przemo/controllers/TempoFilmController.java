package com.przemo.controllers;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.przemo.entity.Film;
import com.przemo.entity.TempFilm;
import com.przemo.service.DatabaseService;

@Transactional
@SessionAttributes(value = {"userId","role"})
@Controller
@RequestMapping("/FilmManagment")
public class TempoFilmController 
{
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/addRequestedFilm")
	public ModelAndView addRequestedFilm(Map<String,Object> map,@RequestParam("filmId") int filmId) 
	{
		TempFilm tempfilm = databaseService.getTempFilm(filmId);
		
		Film film = new Film();
		
		film.setTytul(tempfilm.getTytul());
		
		databaseService.saveFilm(film);
		//clear temp database from this film
		databaseService.deleteTempFilmById(filmId);
		
		return new ModelAndView("redirect:/FilmManagment/addFilmRequestPage");
	}
	
	@GetMapping("/deleteRequestedFilm")
	public ModelAndView deleteRequestedFilm(Map<String,Object> map,@RequestParam("filmId") int filmId) 
	{
		databaseService.deleteTempFilmById(filmId);
		return new ModelAndView("redirect:/FilmManagment/addFilmRequestPage");
	}

}
