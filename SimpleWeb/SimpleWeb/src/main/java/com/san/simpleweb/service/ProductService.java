package com.san.simpleweb.service;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.san.simpleweb.model.Product;
import com.san.simpleweb.repository.ProductRepo;

@Service
public class ProductService 
{
    @Autowired
	ProductRepo repo;
//		
//	List<Product> products = new ArrayList<>(Arrays.asList
//		   (new Product(101,"Iphone",50000), 
//		    new Product(102,"Samsung",15000),
//		    new Product(103, "Realme",10000)));
//   
	public List<Product> getProducts() 
	{
		return  repo.findAll();	
	}
	public Product getProductById(int prodId) 
	{
		return repo.findById(prodId).orElse(new Product());
//		        products.stream()
//    			.filter(p -> p.getProdId() == prodId)
//    			.findFirst().orElse(new Product(100, "No Item", 10000));   
//	
	}
	public void addProduct(Product prod) 
	{
		repo.save(prod);
	}
	public void updateProduct(Product prod)
	{
//		int index = 0;	
//		for(int i=0;i<products.size();i++)
//		{
//			if(products.get(i).getProdId() ==prod.getProdId()) 			
//		    index = i;
//			products.set(index,prod);
//		}
		repo.save(prod);
	}
	public void deleteProduct(int prodId) 
	{
//		int index = 0;	
//		for(int i=0;i<products.size();i++)
//		{
//			if(products.get(i).getProdId() == prodId) 			
//		    index = i;
//			products.remove(index);
//		}
		repo.deleteById(prodId);
	}
}
