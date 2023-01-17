package com.rationcenter.api.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rationcenter.api.entities.Cart;
import com.rationcenter.api.entities.User;

public interface CartRepo extends CrudRepository<Cart,Integer>{
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
