package com.example.courses.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class UserController {

	@PostMapping("user")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		User user = new User();
		user.setUsername(username);
		user.setToken(token);		
		return user;
		
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		//List grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
//		String token = Jwts
//				.builder()
//				.setId("softtekJWT")
//				.setSubject(username)
//				.claim("authorities",
//						grantedAuthorities.stream()
//								.map(GrantedAuthority::getAuthority)
//								.collect(Collectors.toList()))
//				.setIssuedAt(new Date(System.currentTimeMillis()))
//				.setExpiration(new Date(System.currentTimeMillis() + 600000))
//				.signWith(SignatureAlgorithm.HS512,
//						secretKey.getBytes()).compact();



 
try {
	String token = Jwts.builder()
	  .setSubject(username)
	  .setExpiration(new Date(1300819380))
	  .claim("name", "Robert Token Man")
	  .claim("scope", "self groups/admins")
	  .signWith(
	    SignatureAlgorithm.HS256,
	    secretKey.getBytes("UTF-8")
	    )
	  .compact();
	
	return "Bearer " + token;
	
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		
		return "Error ";
		}
}
