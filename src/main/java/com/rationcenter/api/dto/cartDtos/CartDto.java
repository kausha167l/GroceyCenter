package com.rationcenter.api.dto.cartDtos;

import java.util.List;

public class CartDto {
    private List<CartItemDto> cartItems;

    private double totalPrice;
    private double totalSalePrice;

    public CartDto() {
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    @Override
    public String toString() {
        return "CartDto [cartItems=" + cartItems + ", totalPrice=" + totalPrice + ", totalSalePrice=" + totalSalePrice +"]";
    }

    public double getTotalSalePrice() {
        return totalSalePrice;
    }

    public void setTotalSalePrice(double totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }

}
