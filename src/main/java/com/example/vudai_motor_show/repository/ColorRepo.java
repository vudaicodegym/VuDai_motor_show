package com.example.vudai_motor_show.repository;

import com.example.vudai_motor_show.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepo extends JpaRepository<Color, Long> {
    boolean existsByColor(String color);
}
