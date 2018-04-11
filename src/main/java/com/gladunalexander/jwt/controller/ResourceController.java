package com.gladunalexander.jwt.controller;

import com.gladunalexander.jwt.config.TokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexander Gladun
 */

@RestController
public class ResourceController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManager authenticationManager;


    public ResourceController(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam boolean rememberMe) {

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        String token = tokenProvider.createToken(authenticate, rememberMe);

        return token;
    }

    @GetMapping("/private")
    public String secret() {
        return "Private Date";
    }
}
