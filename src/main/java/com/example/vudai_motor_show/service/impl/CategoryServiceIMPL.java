package com.example.vudai_motor_show.service.impl;

import com.example.vudai_motor_show.model.Category;
import com.example.vudai_motor_show.repository.CategoryRepo;
import com.example.vudai_motor_show.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceIMPL implements ICategoryService {
    CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).get();
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public boolean exitsByName(String name) {
        return categoryRepo.existsByCategoryName(name);
    }
}
