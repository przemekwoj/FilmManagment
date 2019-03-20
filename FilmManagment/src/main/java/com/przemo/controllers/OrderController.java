package com.przemo.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.przemo.entity.Film;
import com.przemo.entity.abst.User;
import com.przemo.service.DatabaseService;

@Transactional
@Controller
public class OrderController 
{
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/zmowieniaPage")
	public String zmowieniaPage(Model theModel)
	{
		List<Film> films = databaseService.getAllOrderedFilms();
		List<User> users = new ArrayList<User>();
		
		films.sort(Comparator.comparing(Film::getTytul));
		System.out.println(users.toString());
		for(Film film: films)
		{
			users.add(film.getUser());
		}
		
		theModel.addAttribute("films",films);
		theModel.addAttribute("users",users);
		return "zmowieniaPage";
	}
	
	@GetMapping("/accept")
	public ModelAndView accept(Model theModel,@RequestParam("filmId") int filmId)
	{
		Film film = databaseService.getFilmById(filmId);
		
		film.setIloscwyp(film.getIloscwyp() + 1);
		
		film.setZamowione(true);
		
		Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        date = cal.getTime();
        film.setDatawyp(date);
        
        Date date2 = new Date();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 2);
        date2 = cal.getTime();
        film.setDatazwot(date2);
        
        databaseService.updateFilm(film);

		return new ModelAndView("redirect:/zmowieniaPage");
	}
	
	@GetMapping("/reject")
	public ModelAndView reject(Model theModel,@RequestParam("filmId") int filmId)
	{
		Film film = databaseService.getFilmById(filmId);
		
		film.setDostepnosc(true);
		
		film.setZamowione(false);

		
		User user = film.getUser();
		
		for(Film f: user.getFilms())
		{
			if(f.getId() == filmId)
			{
				user.getFilms().remove(f);
				break;
			}
		}
		
		film.setDatawyp(null);
		film.setDatazwot(null);
		databaseService.updateFilm(film);
		databaseService.updateUser(user);
		
		return new ModelAndView("redirect:/zmowieniaPage");
	}
}
