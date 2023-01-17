package com.rationcenter.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rationcenter.api.entities.Category;
import com.rationcenter.api.repos.CategoryRepo;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    // create category
    public Category createCategory(Category category)
    {
       this.categoryRepo.save(category);
       return category;
    }

    // get all category
    public List<Category> getAllCategories(){
        List<Category> categories = (List<Category>) categoryRepo.findAll();
        return categories.size()!=0 ? categories : null;
    }

    // update category
    public Category editCategory(Category category, int catId)
    {
        Optional<Category> categoryOptional = categoryRepo.findById(catId);
        Category newcat =categoryOptional.get();

        newcat.setCatName(category.getCatName());
        newcat.setDescription(category.getDescription());
        newcat.setImageUrl(category.getImageUrl());

        return categoryRepo.save(newcat);
    }
}
