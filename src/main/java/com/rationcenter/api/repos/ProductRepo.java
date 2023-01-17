package com.rationcenter.api.repos;

import org.springframework.data.repository.CrudRepository;

import com.rationcenter.api.entities.Product;

public interface ProductRepo extends CrudRepository<Product,Integer>{
    
}
