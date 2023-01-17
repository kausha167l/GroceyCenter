package com.rationcenter.api.dto.cartDtos;

import com.rationcenter.api.entities.Cart;
import com.rationcenter.api.entities.Product;

public class CartItemDto {
    private int id;
    private int quantity;
    private Product product;

    public CartItemDto() {
    }

    public CartItemDto(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartItemDto [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
    }

}
