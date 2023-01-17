package com.rationcenter.api.dto;


public class ProductDto {
    
    private int id;

    private String name;
    private String imageUrl;
    private double price;
    private double salePrice;
    private String description;
    private int category_id;
    public ProductDto() {
    }
    public int getId() {
        return id;
    }
    public void setId(int productDtoId) {
        this.id = productDtoId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    @Override
    public String toString() {
        return "ProductDto [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", price="
                + price + ", salePrice=" + salePrice + ", description=" + description + ", category_id=" + category_id
                + "]";
    }

    
    
}
