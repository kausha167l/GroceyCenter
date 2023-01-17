package com.rationcenter.api.repos;

import org.springframework.data.repository.CrudRepository;

import com.rationcenter.api.entities.AuthenticationToken;
import com.rationcenter.api.entities.User;

public interface AuthenticationRepo extends CrudRepository<AuthenticationToken,Integer>{
    AuthenticationToken findByToken(String token);
    AuthenticationToken findByUser(User user);
}
