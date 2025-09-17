package com.Santho.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Santho.SpringSecurity.model.Users;
import com.Santho.SpringSecurity.service.UserService;

@RestController
public class UserController 
{
	@Autowired 
	private UserService service;
	
	@PostMapping("/login")
	public String Login(@RequestBody Users user)
	{
		System.out.println(user);
		return service.verify(user);
	}
    @PostMapping("/register")
	public Users register(@RequestBody Users user)
  {
	return service.register(user);
	  
  }
    
  }
