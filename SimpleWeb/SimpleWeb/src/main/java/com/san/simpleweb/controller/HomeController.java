package com.san.simpleweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@RequestMapping("/")
	@ResponseBody
		public String greet() 
	{
		System.out.println("WebPage");
		return "Welcome to the Santhoshini WebPage!!!";
	}
	@RequestMapping("about")
	@ResponseBody
	public String about() 
	{
		System.out.println("AboutPage");		
		return "We are here to guide you";	
	}
}
