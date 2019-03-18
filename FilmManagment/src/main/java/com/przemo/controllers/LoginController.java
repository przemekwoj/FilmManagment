package com.przemo.controllers;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.przemo.entity.Admin;
import com.przemo.entity.abst.User;
import com.przemo.service.DatabaseService;

@Transactional
@SessionAttributes(value = {"userId","role"})
@Controller
public class LoginController 
{
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/")
	public String loginpage()
	{
		return "loginPage";
	}
	
	@PostMapping("/checkLoginUser")
	public ModelAndView  checkLoginUser(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			RedirectAttributes redirectAttributes,
			Map<String,Object> map)
	{
		//check user in the db
		List<User> listOfUsers = databaseService.getAllUsers();
		for(User u: listOfUsers)
		{
			
			if(u.getEmail().equals(email))
				{
					if(u.getPassword().equals(password))
					{
						ModelAndView modelAndView = new ModelAndView("redirect:/showHomePage");
						modelAndView.addObject("userId", u.getId());
						map.put("userId",u.getId());
						if(u.getClass().getName().equals(Admin.class.getName()))
						{
							map.put("role","Admin");
						}
						else
						{
							map.put("role","NormalUser");
						}
						return  modelAndView;
					}
				}
		}
		//return error page
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		modelAndView.addObject("error", "wrong email or password");
		return modelAndView;
	}
}
