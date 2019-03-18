package com.przemo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.przemo.entity.Aktor;
import com.przemo.entity.Film;
import com.przemo.service.DatabaseService;

@Transactional
@SessionAttributes(value = {"userId","role"})
@Controller
public class MainController
{
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/showHomePage")
	public String showHomePage(Model theModel)
	{
		//pass all films to jsp page
		List<Film> allFilms = databaseService.getAllFilms();
		theModel.addAttribute("allFilms", allFilms);
		
		return "home";
	}
	
	@GetMapping("/test")
	public String test(Model theModel,Map<String,Object> map)
	{
		/*System.out.println("w tescie");
		Film film = databaseService.getFilmById(2);
		Aktor a = new Aktor();
		a.setFirst_name("ahha");
		System.out.println(film.toString());
		System.out.println(a.toString());
		a.add(film);
		databaseService.saveActor(a);
		System.out.println("po tescie");*/
		
		Film film = databaseService.getFilmById(1);
		
		System.out.println(film.getAktorzyList().toString());
		
		theModel.addAttribute("film",film);
		
		
		return "test";
		//return new ModelAndView("redirect:/showHomePage");
	}
}
