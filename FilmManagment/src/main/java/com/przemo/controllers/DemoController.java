package com.przemo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.przemo.entity.Admin;
import com.przemo.entity.NormalUser;
import com.przemo.entity.abst.User;
import com.przemo.service.DatabaseService;

@Transactional
@Controller
public class DemoController 
{
	@Autowired
	private DatabaseService databaseService;

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/us")
	public String us() 
	{
		//List<NormalUser> list = (List<NormalUser>) databaseService.getAllNormalUsers();
		//List<Admin> list = (List<Admin>) databaseService.getAllAdmins();
		List<User> list = (List<User>) databaseService.getAllUsers();

		for(User u: list)
		{
			System.out.println(u.toString() +"   role  "+ u.getClass().getName());
		}
		
		
		
		return "home";
		
	}
	
}
