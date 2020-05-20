package com.example.courses.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.courses.model.JwtUser;
import com.example.courses.security.JwtGenerator;

@RestController
@RequestMapping("/token") //endpoint for generating token
public class TokenController { 


    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @GetMapping
    public String generate(final JwtUser jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }
}