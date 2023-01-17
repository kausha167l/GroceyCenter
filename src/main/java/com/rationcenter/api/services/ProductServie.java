package com.rationcenter.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rationcenter.api.dto.ProductDto;
import com.rationcenter.api.entities.Category;
import com.rationcenter.api.entities.Product;
import com.rationcenter.api.repos.ProductRepo;

@Service
public class ProductServie {

    @Autowired
    ProductRepo productRepo;

    // add product
    public Product addProduct(ProductDto productdto, Category category) {
        Product product = new Product();
        product.setName(productdto.getName());
        product.setImageUrl(productdto.getImageUrl());
        product.setDescription(productdto.getDescription());
        product.setPrice(productdto.getPrice());
        product.setSalePrice(productdto.getSalePrice());
        product.setCategory(category);

        this.productRepo.save(product);
        return product;
    }

    // update product
    public void updateProduct(ProductDto productdto, Integer uid)
    {
        Optional<Product> opProduct = productRepo.findById(uid);
        
        Product product = opProduct.get();

        product.setName(productdto.getName());
        product.setImageUrl(productdto.getImageUrl());
        product.setDescription(productdto.getDescription());
        product.setPrice(productdto.getPrice());
        product.setSalePrice(productdto.getSalePrice());

        productRepo.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setSalePrice(product.getSalePrice());
        productDto.setCategory_id(product.getCategory().getCatId());
        productDto.setId(product.getProductId());

        return productDto;
    }

    // get All Product

    public List<ProductDto> getAllProduct() {
        List<Product> products = (List<Product>) productRepo.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(getProductDto(product));
        }

        return productDtos;
    }

    // get Product by id

    public Product getbyid(int id) {
        Optional<Product> opProduct = productRepo.findById(id);
        System.out.println(opProduct.get());
        return opProduct.get();
    }

    // get productdto by id
    public ProductDto getproductbyid(int id) {
        Optional<Product> opProduct = productRepo.findById(id);
        return getProductDto(opProduct.get());
    }

}
