package com.easynews.easynewsserver.service;

import com.easynews.easynewsserver.config.TokenService;
import com.easynews.easynewsserver.model.UserRequest;
import com.easynews.easynewsserver.model.db.User;
import com.easynews.easynewsserver.model.db.UserRole;
import com.easynews.easynewsserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    private TokenService tokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserRequest userRegRequest) {
        User user = convertToUser(userRegRequest);

        if (this.userRepository.findById(userRegRequest.email()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User email already registered");
        }

        this.userRepository.save(user);
    }


    private User convertToUser(UserRequest userRegRequest) {
        User user = new User();
        user.setEmail(userRegRequest.email());
        user.setPassword(new BCryptPasswordEncoder().encode(userRegRequest.password()));
        user.setRole(UserRole.USER);
        user.setCpf(userRegRequest.cpf());
        user.setDateOfBirth(userRegRequest.dateOfBirth());

        return user;
    }
}
