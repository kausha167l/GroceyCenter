package com.rationcenter.api.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rationcenter.api.entities.AuthenticationToken;
import com.rationcenter.api.entities.User;
import com.rationcenter.api.exception.CustomExceptions;
import com.rationcenter.api.repos.AuthenticationRepo;

@Service
public class AuthenticationSevice {
    @Autowired
    AuthenticationRepo authenticationRepo;

    public void saveToken(AuthenticationToken at){
        authenticationRepo.save(at);
    }

    // authenticate Token
    public void authenticate(String token){
        if(Objects.isNull(token)){
            throw new CustomExceptions("Token not Present");
        }
        if(Objects.isNull(getUser(token))){
            throw new CustomExceptions("Token not valid");
        }
    }
    // Get User from Token
    public User getUser(String token){
        final AuthenticationToken aToken = authenticationRepo.findByToken(token);

        if(Objects.isNull(aToken)){
            return null;
        }
        return aToken.getUser();
    }

    // Get Token from User
    public AuthenticationToken getToken(User user)
    {
        return authenticationRepo.findByUser(user);
    }
}
