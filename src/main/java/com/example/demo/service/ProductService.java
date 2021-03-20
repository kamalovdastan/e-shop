package com.example.demo.service;

import com.example.demo.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    public ProductEntity createProduct(ProductEntity productEntity);

    public ProductEntity getById(Long id) throws Exception;

    public List<ProductEntity> getAll();

    public ProductEntity updateProduct(ProductEntity productEntity, Long id) throws Exception;

    public String deleteProduct(Long id) throws Exception;
}
