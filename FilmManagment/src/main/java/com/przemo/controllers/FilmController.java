package com.przemo.controllers;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.przemo.entity.Film;
import com.przemo.entity.TempFilm;
import com.przemo.entity.abst.User;
import com.przemo.service.DatabaseService;

@Transactional
@SessionAttributes(value = {"userId","role"})
@Controller
@RequestMapping("/FilmManagment")
public class FilmController 
{
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/viewParticularFilm")
	public String viewParticularFilm(@RequestParam("filmId") int filmId,
			@RequestParam("userId") int userId,Model theModel,Map<String,Object> map) throws ParseException
	{
		Film film = databaseService.getFilmById(filmId);

		theModel.addAttribute("film",film);
		theModel.addAttribute("userId",userId);
		theModel.addAttribute("role",map.get("role"));
		
		return "particularFilm";
	}
	
	@GetMapping("/addFilmPage")
	public String addFilmPage(Map<String,Object> map)
	{		
		return "addFilmPage";
	}
	
	@PostMapping("/addingFilm")
	public ModelAndView addingFilm(Map<String,Object> map,@ModelAttribute("newfilm") Film newfilm) 
	{
		//if User else Admin
		if(map.get("role").equals("Admin"))
		{
			databaseService.saveFilm(newfilm);
		}
		else if(map.get("role").equals("NormalUser"))
		{
			TempFilm tempfilm = new TempFilm();
			tempfilm.setTytul(newfilm.getTytul());
			databaseService.saveTempFilm(tempfilm);
		}
		return new ModelAndView("redirect:/showHomePage");
	}
	
	@RequestMapping("/deleteFilm")
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId)
	{
		databaseService.deleteFilmById(filmId);
		
		return new ModelAndView("redirect:/showHomePage");
	}
	
	@RequestMapping("/updateFilmPage")
	public String updateFilmPage(Model theModel,@RequestParam("filmId") int filmId)
	{
		
		Film film = databaseService.getFilmById(filmId);	
		theModel.addAttribute("film",film);

		return "updateFilmPage";
	}
	
	@RequestMapping("/orderFilm")
	public ModelAndView orderFilmPage(@RequestParam("filmId") int filmId,
			@RequestParam("userId") int userId)
	{
		User user = databaseService.getUserById(userId);
		
		Film film = databaseService.getFilmById(filmId);
		
		film.setDostepnosc(false);
		
		/*film.setIloscwyp(film.getIloscwyp() + 1);
		
		Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        date = cal.getTime();
        film.setDatawyp(date);
        
        Date date2 = new Date();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 2);
        date2 = cal.getTime();
        film.setDatazwot(date2);*/

		System.out.println("podusmowanie : "+ film.getDatawyp() + " + "+film.getDatazwot());
		user.add(film);
		
		databaseService.updateUser(user);
		
		return new ModelAndView("redirect:/showHomePage");
	}
	
	@RequestMapping("/updateFilm")
	public ModelAndView updateFilm(@ModelAttribute("film") Film film)
	{
		databaseService.updateFilm(film);
		
		return new ModelAndView("redirect:/showHomePage");
	}
	
	
	@GetMapping("/addFilmRequestPage")
	public String addFilmRequestPage(Model theModel,Map<String,Object> map)
	{		
		List<TempFilm> allRequestFilms = databaseService.getAllTempFilm();
		
		theModel.addAttribute("allRequestFilms", allRequestFilms);
		
		return "addFilmRequestPage";
	}
	
	@GetMapping("/backToHomePage")
	public ModelAndView backToHomePage(Map<String,Object> map) 
	{

		return new ModelAndView("redirect:/showHomePage");
	}
	
	
}
