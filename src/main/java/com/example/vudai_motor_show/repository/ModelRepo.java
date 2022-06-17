package com.example.vudai_motor_show.repository;

import com.example.vudai_motor_show.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, Long> {
}
