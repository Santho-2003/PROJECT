package com.san.simpleweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController 
{		
	@RequestMapping("login")
	@ResponseBody
	public String login() 
	{
		return "Welcome to our login page";
	}
	}

