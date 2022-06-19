package com.example.vudai_motor_show.service.impl;

import com.example.vudai_motor_show.model.Model;
import com.example.vudai_motor_show.repository.ModelRepo;
import com.example.vudai_motor_show.service.IModelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelServiceIMPL implements IModelService {
    ModelRepo modelRepo;

    @Override
    public Page<Model> findAll(Pageable pageable) {
        return modelRepo.findAll(pageable);
    }

    @Override
    public Model findById(Long id) {
        return modelRepo.findById(id).get();
    }

    @Override
    public void save(Model model) {
        modelRepo.save(model);
    }

    @Override
    public boolean existByName(String name) {
        return modelRepo.existsByName(name);
    }
}
