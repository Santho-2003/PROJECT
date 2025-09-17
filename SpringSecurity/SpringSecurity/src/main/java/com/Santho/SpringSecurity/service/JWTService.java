package com.Santho.SpringSecurity.service;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

//import java.awt.RenderingHints.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.security.core.userdetails.UserDetails;

//import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService 
{
	private String secretKey ="mysupersecretkeymysupersecretkeymysupersecretkey";
	public JWTService() 
	{
		try 
		{
			KeyGenerator keygen = KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = keygen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		} catch (NoSuchAlgorithmException e) 
		{
			throw new RuntimeException(e);
		}
	}
	public String generateToken(String username) 
	{
		Map<String,Object> claims = new HashMap<>();
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 * 10))
				.and()
				.signWith(getKey())
				.compact();				
	}
	private java.security.Key getKey() 
	{
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String extractUserName(String token) 
	{
		return token;
	}
//
//	public boolean validateToken(String token, UserDetails userDetails) 
//	{
//		return true;
//	}
	
//	 public String extractUserName(String token) 
//	    {
//		 return Jwts.parser()
//		           .setSigningKey(getKey())
//		           .parseClaimsJws(token)
//		           .getBody()
//		           .getSubject();
//
//	    }

	    public boolean validateToken(String token, UserDetails userDetails) 
	    {
	        final String username = extractUserName(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

	    private boolean isTokenExpired(String token) 
	    {
	        Date expiration = Jwts.parser()
	                .setSigningKey(getKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody()
	                .getExpiration();
	        return expiration.before(new Date());
	    }
	
}
