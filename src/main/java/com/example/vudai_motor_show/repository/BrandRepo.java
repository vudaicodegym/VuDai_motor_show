package com.example.vudai_motor_show.repository;

import com.example.vudai_motor_show.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long>{
    boolean existsByBrandName(String brandName);
}
