package com.rationcenter.api.repos;

import org.springframework.data.repository.CrudRepository;

import com.rationcenter.api.entities.Category;

public interface CategoryRepo extends CrudRepository<Category,Integer>{
    
}
