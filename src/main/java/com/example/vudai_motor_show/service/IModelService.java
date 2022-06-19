package com.example.vudai_motor_show.service;

import com.example.vudai_motor_show.model.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IModelService {
    Page<Model> findAll(Pageable pageable);
    Model findById(Long id);
    void save(Model model);
    boolean existByName(String name);
}
