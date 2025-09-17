package com.Santho.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController 
{
@GetMapping("/")
public String Greet(HttpServletRequest request) 
{
	return "Welcome to Santhoshini's Security"+request.getSession().getId();
}
}
