package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public List<CategoryEntity> getCategories() {
        return categoryService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CategoryEntity getCategoryById(@PathVariable("id") Long id) throws Exception {
        return categoryService.getById(id);
    }

    @PostMapping()
    public CategoryEntity postCategory(CategoryEntity category) {
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public CategoryEntity putCategoryById(@PathVariable("id") Long id, @RequestBody CategoryEntity category) throws Exception {
        return categoryService.updateById(id, category);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable("id") Long id) throws Exception {
        return categoryService.deleteById(id);
    }
}
