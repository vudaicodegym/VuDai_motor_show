package com.example.vudai_motor_show.service.impl;

import com.example.vudai_motor_show.model.Product;
import com.example.vudai_motor_show.repository.ProductRepo;
import com.example.vudai_motor_show.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceIMPL implements IProductService {
    ProductRepo productRepo;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public void Save(Product product) {
        productRepo.save(product);
    }

    @Override
    public boolean existsByModelName(String modelName) {
        return productRepo.existsByModelName(modelName);
    }
}
