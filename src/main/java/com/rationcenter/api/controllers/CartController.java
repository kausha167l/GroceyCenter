package com.rationcenter.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rationcenter.api.dto.cartDtos.AddToCartDto;
import com.rationcenter.api.dto.cartDtos.CartDto;
import com.rationcenter.api.dto.userDtos.ResponseDto;
import com.rationcenter.api.entities.User;
import com.rationcenter.api.services.AuthenticationSevice;
import com.rationcenter.api.services.CartService;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @Autowired
    AuthenticationSevice authenticationSevice;

    // add to cart
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addToCart(@RequestBody AddToCartDto acdto, @RequestHeader("token") String token) {
        // authenticate token
        authenticationSevice.authenticate(token);

        // find user
        User user = authenticationSevice.getUser(token);

        System.out.println(acdto+token);
        cartService.addToCart(acdto, user);

        return ResponseEntity.ok(new ResponseDto("added to cart of user " + user.getFirstName(), token));
    }

    // get all cart item
    @GetMapping("/get_cart_list")
    public ResponseEntity<CartDto> getCartList(@RequestHeader("token") String token) {
        // authenticate token
        authenticationSevice.authenticate(token);

        // find user
        User user = authenticationSevice.getUser(token);

        CartDto cdto = cartService.listCartItem(user);

        return ResponseEntity.ok(cdto);
    }
}
