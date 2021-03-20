package com.example.demo.service.impl;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getById(Long id) throws Exception {
        return categoryRepository.findById(id).orElseThrow(() ->
                new Exception("(Category) Record not found with id: " + id));
    }

    @Override
    public CategoryEntity create(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateById(Long id, CategoryEntity category) throws Exception {
        return categoryRepository.findById(id)
                .map(newCategory -> {
                    newCategory.setName(category.getName());
                    newCategory.setDescription(category.getDescription());
                    return categoryRepository.save(newCategory);
                }).orElseThrow(() ->
                        new Exception("(Category) Record not found with id: " + id));
    }

    @Override
    public String deleteById(Long id) throws Exception {
        categoryRepository.findById(id).orElseThrow(() -> new Exception("(Category) Record not found with id: " + id));
        categoryRepository.deleteById(id);
        return "(Category) Record with id: " + id + " has been deleted!";
    }
}
