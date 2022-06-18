package com.example.vudai_motor_show.service;

import com.example.vudai_motor_show.model.Brand;

import java.util.List;

public interface IBrandService{
    List<Brand> findALl();
    Brand findBrandById(Long id);
    void save(Brand brand);
    boolean existsByBrandName(String brandName);
}
