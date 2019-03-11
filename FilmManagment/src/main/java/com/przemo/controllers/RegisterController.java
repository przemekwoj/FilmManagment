package com.przemo.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.przemo.entity.NormalUser;
import com.przemo.entity.abst.User;
import com.przemo.service.DatabaseService;

@Transactional
@Controller
public class RegisterController 
{
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/registrationPage")
	public String registerPage()
	{
		return "registrationPage";
	}
	
	@PostMapping("/checkRegistration")
	public ModelAndView checkRegistration(@ModelAttribute("normalUser") NormalUser normalUser)
	{
			//check user in the db
				List<User> listOfUsers = databaseService.getAllUsers();
				for(User u: listOfUsers)
				{
					
					if(u.getEmail().equals(normalUser.getEmail()))
						{
						//return error page
						ModelAndView modelAndView = new ModelAndView("redirect:/registrationPage");
						modelAndView.addObject("error", "email already exist");
						return modelAndView;
						}
				}
				databaseService.saveNormalUser(normalUser);
				return new ModelAndView("redirect:/");
	}
}
