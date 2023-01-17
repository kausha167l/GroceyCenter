package com.rationcenter.api.repos;

import org.springframework.data.repository.CrudRepository;

import com.rationcenter.api.entities.User;

public interface UserRepo extends CrudRepository<User,Integer>{
    User findByEmail(String email);
}
