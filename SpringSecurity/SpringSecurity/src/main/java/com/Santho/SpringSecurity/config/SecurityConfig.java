package com.Santho.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //this is used to remove the login credentials from the website add use our own
public class SecurityConfig 
{
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtFilter jwtFilter;
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
    {
   	    return http.csrf(customizer -> customizer.disable()).
    	authorizeHttpRequests(request -> request
    	.requestMatchers("/register","/login")
    	.permitAll().anyRequest().authenticated())       
    	.//formLogin(Customizer.withDefaults()).   //we can create login form instead of default (we can disable to access it by popup form)
    	httpBasic(Customizer.withDefaults()).   //this is for access homepage instead of html form (we can disable to access it by popup form)
    	sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).   //to get new sessionid to prevent from hacking
    	addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
    	.build (); 
    	
//    	Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>()
//        {			
//			@Override
//			public void customize(CsrfConfigurer<HttpSecurity> Customizer) 
//			{
//				// TODO Auto-generated method stub
//				Customizer.disable();
//			}
//        };        
//    	http.csrf(custCsrf);  (instead of these lines we can use only one line as)
//  	                        http.csrf(customizer -> customizer.disable())
   	       	
//   	return http.build();
    }
    
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//    	
//    	UserDetails user1 = User
//    			.withDefaultPasswordEncoder()
//    			.username("nila")
//    			.password("k@123")
//    			.roles("USER")
//    			.build();
//    	
//    	UserDetails user2 = User
//    			.withDefaultPasswordEncoder()
//    			.username("sheela")
//    			.password("sheela@123")
//    			.roles("ADMIN")
//    			.build();
//    	return new InMemoryUserDetailsManager(user1, user2);
//    }(Hardcoded so we going to next step datas should come from db)
    
    
    @Bean
    public AuthenticationProvider authenticationProvider() 
    {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());// if it is used postman wont support 
    	//the encrypted password even it is correct so the next line is 
    	provider.setPasswordEncoder(new BCryptPasswordEncoder(12));// it is used to accept even entered the encryptd pssword
    	provider.setUserDetailsService(userDetailsService);
    	return provider;
    }
    
    //jwt
    @Bean
    public AuthenticationManager aunthenticationManager(AuthenticationConfiguration config)throws Exception
    {
    	return config.getAuthenticationManager();
    }
}
