package com.example.vudai_motor_show.service.impl;

import com.example.vudai_motor_show.model.Brand;
import com.example.vudai_motor_show.repository.BrandRepo;
import com.example.vudai_motor_show.service.IBrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BrandServiceIMPL implements IBrandService {
    BrandRepo brandRepo;

    @Override
    public List<Brand> findALl() {
        return brandRepo.findAll();
    }

    @Override
    public Brand findBrandById(Long id) {
        return brandRepo.findById(id).get();
    }

    @Override
    public void save(Brand brand) {
        brandRepo.save(brand);
    }

    @Override
    public boolean existsByBrandName(String brandName) {
        return brandRepo.existsByBrandName(brandName);
    }
}
