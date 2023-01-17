package com.rationcenter.api.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rationcenter.api.dto.cartDtos.CartDto;
import com.rationcenter.api.dto.cartDtos.CartItemDto;
import com.rationcenter.api.dto.cartDtos.AddToCartDto;
import com.rationcenter.api.entities.Cart;
import com.rationcenter.api.entities.Product;
import com.rationcenter.api.entities.User;
import com.rationcenter.api.repos.CartRepo;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ProductServie productServie;

    // add to cart
    public void addToCart(AddToCartDto acdto, User user){
       
        Product p = productServie.getbyid(acdto.getProduct_id());//
       
        Cart cart = new Cart();

        cart.setProduct(p);
        cart.setUser(user);
        cart.setQuantity(acdto.getQuantity());
        cart.setCreatedDate(new Date());
        
        cartRepo.save(cart);
    }

    // get all cart items
    public CartDto listCartItem(User u){
        List<Cart> cartList = cartRepo.findAllByUserOrderByCreatedDateDesc(u);

        List<CartItemDto>cartItems = new ArrayList<>();
        double totalPrice = 0;
        double totalSalePrice = 0;

        for(Cart c : cartList){
            CartItemDto cidto = new CartItemDto(c);

            totalPrice += cidto.getQuantity()*cidto.getProduct().getPrice();
            totalSalePrice += cidto.getQuantity()*cidto.getProduct().getSalePrice();
            
            cartItems.add(cidto);
        }

        CartDto cdto = new CartDto();

        cdto.setCartItems(cartItems);
        cdto.setTotalPrice(totalPrice);
        cdto.setTotalSalePrice(totalSalePrice);

        return cdto;
    }
}
