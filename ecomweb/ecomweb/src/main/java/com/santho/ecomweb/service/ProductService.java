package com.santho.ecomweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.santho.ecomweb.model.Product;
import com.santho.ecomweb.repo.ProductRepo;

@Service
public class ProductService 
{
    @Autowired
	private ProductRepo repo;
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	
}
