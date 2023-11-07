package com.easynews.easynewsserver.controllers;


import com.easynews.easynewsserver.model.AuthRequest;
import com.easynews.easynewsserver.model.UserRequest;
import com.easynews.easynewsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity authenticateUser(@RequestBody AuthRequest authRequest) {
        System.out.println("senha:: " + authRequest.password());
        var usernamePassword = new UsernamePasswordAuthenticationToken(authRequest.email(), authRequest.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody UserRequest userRequest) {
        userService.registerUser(userRequest);
    }

}
