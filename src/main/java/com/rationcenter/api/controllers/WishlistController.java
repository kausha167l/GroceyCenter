package com.rationcenter.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rationcenter.api.dto.ProductDto;
import com.rationcenter.api.dto.userDtos.SignInResponseDto;
import com.rationcenter.api.entities.Product;
import com.rationcenter.api.entities.User;
import com.rationcenter.api.entities.Wishlist;
import com.rationcenter.api.services.AuthenticationSevice;
import com.rationcenter.api.services.WishlistService;



@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    @Autowired
    AuthenticationSevice authenticationSevice;

    // save product in wishlist
    @PostMapping("/add")
    public ResponseEntity<SignInResponseDto> addItem(@RequestBody Product product, @RequestHeader("token") String token){
        // authenticate token
        authenticationSevice.authenticate(token);
        System.out.println("token verified"+product.toString());

        // find user
        User user = authenticationSevice.getUser(token);
        System.out.println("user found");
        // save item
        Wishlist wishlist = new Wishlist(user, product);
        System.out.println("new wishlist obj created");

        wishlistService.createWishlist(wishlist);

        return ResponseEntity.ok(new SignInResponseDto("added to wishlist",token));
    }

    // get all wishlist item
    @GetMapping("/get_wishlist")
    public ResponseEntity<List<ProductDto>> getAllWishlistItems(@RequestHeader("token") String token){
        // authenticate token
        authenticationSevice.authenticate(token);

        // find user
        User user = authenticationSevice.getUser(token);
        
        return ResponseEntity.ok(wishlistService.getWishlist(user));
    }
}
