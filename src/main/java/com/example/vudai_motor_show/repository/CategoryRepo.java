package com.example.vudai_motor_show.repository;

import com.example.vudai_motor_show.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    boolean existsByCategoryName(String categoryName);
}
