package com.san.simpleweb.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Product 
{
public int getProdId() 
{
		return prodId;
}
	public void setProdId(int prodId) 
	{
		this.prodId = prodId;
	}
	public String getProdName() 
	{
		return prodName;
	}
	public void setProdName(String prodName) 
	{
		this.prodName = prodName;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}

@Id	
private int prodId;
private String prodName;
private int price;

public Product(int prodId, String prodName, int price) 
{
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.price = price;
}
public Product() 
{
	
}
@Override
public String toString() 
{
	return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", getProdId()=" + getProdId()
			+ ", getProdName()=" + getProdName() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
}
