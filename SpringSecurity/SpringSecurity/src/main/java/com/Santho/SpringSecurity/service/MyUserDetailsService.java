package com.Santho.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Santho.SpringSecurity.model.UserPrincipal;
import com.Santho.SpringSecurity.model.Users;
import com.Santho.SpringSecurity.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
	private UserRepo repo;
	
   @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
	   Users user = repo.findByUsername(username);
	   if(user==null) 
	   {
		System.out.println("User not found");   
	    throw new UsernameNotFoundException("user not found");
	   }
	   return new UserPrincipal(user);
	}

}
