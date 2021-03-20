package com.example.demo.service.impl;

import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity getById(Long id) throws Exception {
        return productRepository.findById(id).orElseThrow(() -> new Exception("(Product) Record not found with id: " + id));
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity, Long id) throws Exception {
        return productRepository.findById(id)
                .map(newProduct -> {
                    newProduct.setName(productEntity.getName());
                    newProduct.setDescription(productEntity.getDescription());
                    newProduct.setPrice(productEntity.getPrice());
                    newProduct.setCategory(productEntity.getCategory());
                    return productRepository.save(newProduct);
                }).orElseThrow(() -> new Exception("(Product) Record not found with id: " + id));
    }

    @Override
    public String deleteProduct(Long id) throws Exception {
        productRepository.findById(id).orElseThrow(() -> new Exception("(Product) Record not found with id: " + id));
        productRepository.deleteById(id);
        return "(Product) Record with id: " + id + " has been deleted!";
    }

}
