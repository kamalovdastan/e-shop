package com.example.demo.service;

import com.example.demo.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    public List<CategoryEntity> getAll();

    public CategoryEntity getById(Long id) throws Exception;

    public CategoryEntity create(CategoryEntity category);

    public CategoryEntity updateById(Long id, CategoryEntity category) throws Exception;

    public String deleteById(Long id) throws Exception;
}
