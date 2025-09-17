package com.Santho.SpringSecurity.service;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.Santho.SpringSecurity.model.Users;
import com.Santho.SpringSecurity.repo.UserRepo;

@Service
public class UserService 
{
   @Autowired
   private UserRepo repo;
   
   @Autowired
   private JWTService JWTService;
   
   @Autowired
   AuthenticationManager authManager;
   private BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder(12);

private String username;
   public Users register(Users user)
   {
	   user.setPassword(encrypt.encode(user.getPassword()));
	   return repo.save(user);	   
   }
public String verify(Users user) 
{
	org.springframework.security.core.Authentication authentication = 
			authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	
	if(authentication.isAuthenticated())
		return JWTService.generateToken(username);	
	return "fail";
}
}
