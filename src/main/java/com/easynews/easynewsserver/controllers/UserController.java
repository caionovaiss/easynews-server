package com.easynews.easynewsserver.controllers;

import com.easynews.easynewsserver.config.TokenService;
import com.easynews.easynewsserver.model.*;
import com.easynews.easynewsserver.model.db.News;
import com.easynews.easynewsserver.model.db.User;
import com.easynews.easynewsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @PostMapping("/update")
    public User updateUserData(@RequestBody UpdateUserRequest updateUserRequest) {
        return userService.updateUserData(updateUserRequest);
    }

    @GetMapping
    public UserResponse getUser(@RequestBody GetUserRequest getUserRequest) {
        System.out.println("user email: " + getUserRequest.userEmail());
        return userService.getUser(getUserRequest.userEmail());
    }

    @GetMapping("/getUserFavoriteNews")
    public Set<String> getUserFavoriteNews(@RequestBody GetUserRequest getUserRequest) {
        return userService.getAllUserFavoriteNews(getUserRequest.userEmail());
    }
}