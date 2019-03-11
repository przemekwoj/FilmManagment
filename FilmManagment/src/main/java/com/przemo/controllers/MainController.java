package com.przemo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
}
