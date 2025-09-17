package com.santho.ecomweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santho.ecomweb.model.Product;
import com.santho.ecomweb.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController 
{
@Autowired
private ProductService service;

@GetMapping("/")
public String greet() 
{
	return "Hello World";
}
@GetMapping("/products")
public List<Product> getAllProducts()
{
	return service.getAllProducts();
}
}
