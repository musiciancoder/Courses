package com.example.courses.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

import javax.servlet.*;

import javax.servlet.http.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.*;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "mySecretKey";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		try {
			if (existeJWTToken(request, response)) {
				Claims claims = validateToken(request);
				if (claims.get("authorities") != null) { //pasa los authorithies a claims
					setUpSpringAuthentication(claims);
				} else {
							
					SecurityContextHolder.clearContext();
				}
			}
			chain.doFilter(request, response);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
	}	

	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}

	/**
	 * Metodo para autenticarnos dentro del flujo de Spring
	 * 
	 * @param claims
	 */
	
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		 List <String> authorizations = (List<String>) claims.get("authorities");
		 List<SimpleGrantedAuthority> authority = authorizations.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
		  // var authorities = ((List<?>) parsedToken.getBody()
		
		/*
		 * var authoritiesv = ((List<authorities>) parsedToken.getBody()
		 * .get("rol")).stream() .map(authority -> new SimpleGrantedAuthority((String)
		 * authority)) .collect(Collectors.toList());
		 */
		
		//Stream authoritiesn = authorities.stream().map(authority -> new SimpleGrantedAuthority((String) authority));
		
		UsernamePasswordAuthenticationToken auth =new UsernamePasswordAuthenticationToken(null, null, authority);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		//AbstractAuthenticationToken(java.util.Collection<? extends GrantedAuthority> authorities) {
		}
		
		//SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority();
		
		
		//SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority();
		
		/*
		 * UsernamePasswordAuthenticationToken auth = new
		 * UsernamePasswordAuthenticationToken(claims.getSubject(), null,
		 * authorities.stream().map(authority -> new
		 * SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList()));
		 * SecurityContextHolder.getContext().setAuthentication(auth);
		 */
		 

	

	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		return true;
	}

}
