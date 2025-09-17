package com.Santhoshini.myapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Dev 
{
    @Autowired   
	private Computer comp;
	public void build() 
    {
	comp.compile();
	comp.debug();
	System.out.println("Working on the awesome project !!!");
    }
}
