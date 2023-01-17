package com.rationcenter.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rationcenter.api.dto.ProductDto;
import com.rationcenter.api.entities.User;
import com.rationcenter.api.entities.Wishlist;
import com.rationcenter.api.repos.WishlistRepo;

@Service
public class WishlistService {

    @Autowired
    WishlistRepo wishlistRepo;
    @Autowired
    ProductServie productServie;

    // add item
    public void createWishlist(Wishlist wl)
    {
        wishlistRepo.save(wl);
    }

    // get all items
    public List<ProductDto> getWishlist(User user)
    {
        final List<Wishlist> wishlists = wishlistRepo.findAllByUserOrderByCreatedDateDesc(user);

        List<ProductDto> pdtos = new ArrayList<>();

        for(Wishlist wl : wishlists){
            pdtos.add(productServie.getProductDto(wl.getProduct()));
        }

        return pdtos;
    }
}
