package com.example.vudai_motor_show.repository;

import com.example.vudai_motor_show.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
