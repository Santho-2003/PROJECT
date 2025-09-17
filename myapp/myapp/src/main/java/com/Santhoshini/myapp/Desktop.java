package com.Santhoshini.myapp;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer
{
public void compile()
{
	System.out.println("Compiling with 404 bugs but faster");
}
public void debug() 
{
	System.out.println("Debuging done successfully");
}
}