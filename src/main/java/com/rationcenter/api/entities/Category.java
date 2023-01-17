package com.rationcenter.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;

    @Column(nullable = false)
    private String  catName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String imageUrl;

    
    public Category() {
    }


    public Category(int catId, String description, String imageUrl, String  catName) {
        this.catId = catId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.catName = catName;
    }


    public int getCatId() {
        return catId;
    }


    public void setCatId(int catId) {
        this.catId = catId;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Category [catId=" + catId + ", description=" + description + ", imageUrl=" + imageUrl + ", catImage=" + catName + "]";
    }


    public String getCatName() {
        return catName;
    }


    public void setCatName(String catName) {
        this.catName = catName;
    }

    
    
}
