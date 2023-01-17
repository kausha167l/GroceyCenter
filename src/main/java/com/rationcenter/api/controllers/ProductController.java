package com.rationcenter.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rationcenter.api.dto.ProductDto;
import com.rationcenter.api.entities.Category;
import com.rationcenter.api.entities.Product;
import com.rationcenter.api.repos.CategoryRepo;
import com.rationcenter.api.services.ProductServie;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServie productServie;
    @Autowired
    CategoryRepo categoryRepo;

    // add product
    @PostMapping("/add")
    public ResponseEntity<Product> addproduct(@RequestBody ProductDto productDto) {
        Optional<Category> opCategory = categoryRepo.findById(productDto.getCategory_id());

        if (!opCategory.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(productServie.addProduct(productDto, opCategory.get()));
        }
    }

    // update product
    @PostMapping("/update/{cid}")
    public ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto, @PathVariable("cid") int cid) {
        Optional<Category> opCategory = categoryRepo.findById(productDto.getCategory_id());
        System.out.println("opcategory" + opCategory);
        if (!opCategory.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            productServie.updateProduct(productDto, cid);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    // get all product
    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getAllproducts() {
        try {
            return ResponseEntity.ok(productServie.getAllProduct());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // get product by id
    @GetMapping("/list/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(productServie.getproductbyid(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
