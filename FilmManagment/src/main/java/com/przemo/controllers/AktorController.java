package com.przemo.controllers;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.przemo.entity.Aktor;
import com.przemo.entity.Film;
import com.przemo.entity.wrapperClasses.AktorWrapper;
import com.przemo.service.DatabaseService;

@Transactional
@SessionAttributes(value = {"userId","role"})
@Controller
public class AktorController 
{
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/aktorzy")
	public String aktorzy(@RequestParam("filmId") int filmId,
			@RequestParam("userId") int userId,Model theModel)  
	{
		Film film = databaseService.getFilmById(filmId);
		List<Aktor> listaAktorow = new ArrayList<Aktor>();
		List<Aktor> la = film.getAktorzyList();
		for(Aktor a: la)
		{
			Aktor aktor = new Aktor();
			aktor.setAktorzy_id(a.getAktorzy_id());
			aktor.setFilmsList(a.getFilmsList());
			aktor.setFirst_name(a.getFirst_name());
			aktor.setLast_name(a.getLast_name());
			listaAktorow.add(aktor);
		}
		
		AktorWrapper actorWrapper = new AktorWrapper();
		actorWrapper.setActors(listaAktorow);
		theModel.addAttribute("listaAktorow",listaAktorow);
		theModel.addAttribute("actorWrapper",actorWrapper);
		return "aktorzyPage";
	}
	
	@PostMapping("/changeActor")
	public ModelAndView changeActor(@ModelAttribute("actorWrapper") AktorWrapper actorWrapper,
			@RequestParam("userId") int userId,	@RequestParam("filmId") int filmId)  
	{
		List<Aktor> listaAktorow = new ArrayList<Aktor>();
		
		listaAktorow = actorWrapper.getActors();
		
		Film film = databaseService.getFilmById(filmId);
		
		List<Aktor> dbActors = film.getAktorzyList();
		int i =0;
		for(Aktor aktor: listaAktorow)
		{
			if( (!aktor.getFirst_name().equals(dbActors.get(i).getFirst_name())) || (!aktor.getLast_name().equals(dbActors.get(i).getLast_name())) )
			{
				Aktor a = databaseService.getActorById(dbActors.get(i).getAktorzy_id());
				
				a.setFirst_name(aktor.getFirst_name());
				a.setLast_name(aktor.getLast_name());
				
				databaseService.updateActor(a);
			}
			i++;
		}
	
		ModelAndView modelAndView = new ModelAndView("redirect:/aktorzy");
		modelAndView.addObject("filmId",filmId);
		modelAndView.addObject("userId",userId);

		return modelAndView;
	}
	
	
	@GetMapping("/addActorPage")
	public String addActorPage(@RequestParam("filmId") int filmId,
			@RequestParam("userId") int userId,@ModelAttribute("aktor") Aktor aktor)  
	{
		return "addActorPage";
	}
	
	@PostMapping("/addActor")
	public ModelAndView addActor(@RequestParam("filmId") int filmId,
			@RequestParam("userId") int userId,@ModelAttribute("aktor") Aktor aktor)  
	{
		//sprawczay czy jzu nie istnieje
		List<Aktor> actors = databaseService.getAllActors();
		
		boolean isExistActor = false;
		boolean isActor = false;
		int id_actor = 0;
		for(Aktor a: actors)
		{
			if(a.getFirst_name().equals(aktor.getFirst_name()) && a.getLast_name().equals(aktor.getLast_name()))
			{
				isExistActor = true;
				id_actor = a.getAktorzy_id();
				break;
			}
		}
		
		if(isExistActor)
		{
			Film film = databaseService.getFilmById(filmId);
			Aktor a = databaseService.getActorById(id_actor);
			for(Aktor ak : film.getAktorzyList())
			{
				if(a.getFirst_name().equals(ak.getFirst_name()) && a.getLast_name().equals(ak.getLast_name()))
				{
				isActor = true;
				}
			}
			if(!isActor)
			{
			film.add(a);
			databaseService.updateFilm(film);
			}
		}
		else
		{
			databaseService.saveActor(aktor);
			Film film = databaseService.getFilmById(filmId);
			film.add(aktor);
			databaseService.updateFilm(film);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/aktorzy");
		modelAndView.addObject("filmId",filmId);
		modelAndView.addObject("userId",userId);

		return modelAndView;
	}
	
	@RequestMapping("/deleteActorFromFilm")
	public ModelAndView deleteActorFromFilm(@RequestParam("filmId") int filmId,
			@RequestParam("userId") int userId,@RequestParam("aktorId") int aktorId)  
	{
		
		databaseService.deleteActorFromFilmById(aktorId, filmId);
		ModelAndView modelAndView = new ModelAndView("redirect:/aktorzy");
		modelAndView.addObject("filmId",filmId);
		modelAndView.addObject("userId",userId);

		return modelAndView;
	}
}
