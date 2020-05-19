package com.example.courses.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class UserController {

	@GetMapping("/token")
    public void getJWTToken() {
		String secretKey = "mySecretKey";
		List <GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(null); //authorities
		
		String token = Jwts
				.builder()
				.claim("authorities", grantedAuthorities.stream()
						  .map(GrantedAuthority::getAuthority) .collect(Collectors.toList()))
				//.setId("softtekJWT")
				//.setSubject(username)
				/*
				 * .claim("authorities", grantedAuthorities.stream()
				 * .map(GrantedAuthority::getAuthority) .collect(Collectors.toList()))
				 */
				/*
				 * .claim("authorities", grantedAuthorities.stream()
				 * .map(GrantedAuthority::getAuthority) .collect(Collectors.toList())) //getAuthority() pasa los authorities a string
				 */
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();
		
		System.out.println("token: " + token);

		//return "Bearer " + token;

 
/*try {
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
		}*/
}
}
