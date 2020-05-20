package com.example.courses.security;

import com.example.courses.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator { //Authorization class


    private String secret = "youtube";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUserName(); 
            jwtUser.setId(); 
            jwtUser.setRole();

			/*
			 * jwtUser.setUserName(body.getSubject()); jwtUser.setId(Long.parseLong((String)
			 * body.get("userId"))); jwtUser.setRole((String) body.get("role"));
			 */
            
            
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
