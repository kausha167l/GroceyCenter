package com.rationcenter.api.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rationcenter.api.entities.User;
import com.rationcenter.api.entities.Wishlist;

public interface WishlistRepo extends CrudRepository<Wishlist,Integer>{
    List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);
}
