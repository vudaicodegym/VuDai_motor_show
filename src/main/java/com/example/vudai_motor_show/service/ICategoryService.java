package com.example.vudai_motor_show.service;

import com.example.vudai_motor_show.model.Category;

import java.util.List;

public interface ICategoryService {
        List<Category> findAll();
        Category findById(Long id);
        void save(Category category);
        boolean exitsByName(String name);
}
