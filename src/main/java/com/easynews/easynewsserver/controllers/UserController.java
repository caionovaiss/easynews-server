package com.easynews.easynewsserver.controllers;

import com.easynews.easynewsserver.config.TokenService;
import com.easynews.easynewsserver.model.AuthRequest;
import com.easynews.easynewsserver.model.AuthResponse;
import com.easynews.easynewsserver.model.UserRequest;
import com.easynews.easynewsserver.model.db.User;
import com.easynews.easynewsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/authenticate")
    public AuthResponse authenticateUser(@RequestBody AuthRequest authRequest) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return new AuthResponse(token);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRequest userRequest) {
        userService.registerUser(userRequest);
    }

}
