package com.example.vudai_motor_show.service;

import com.example.vudai_motor_show.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(Long id);
    void Save(Product product);
    boolean existsByModelName(String modelName);

}

