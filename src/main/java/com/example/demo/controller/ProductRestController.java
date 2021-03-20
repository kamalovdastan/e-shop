package com.example.demo.controller;

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public List<ProductEntity> getProducts() {
        return productService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ProductEntity getProductById(@PathVariable("id") Long id) throws Exception {
        return productService.getById(id);
    }

    @PostMapping()
    public ProductEntity postProduct(ProductEntity product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ProductEntity putProductById(@PathVariable("id") Long id, @RequestBody ProductEntity product) throws Exception {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") Long id) throws Exception {
        return productService.deleteProduct(id);
    }
}
