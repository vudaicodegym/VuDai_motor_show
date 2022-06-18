package com.example.vudai_motor_show.service.impl;

import com.example.vudai_motor_show.model.Color;
import com.example.vudai_motor_show.repository.ColorRepo;
import com.example.vudai_motor_show.service.IColorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ColorServiceIMPL implements IColorService {
    ColorRepo colorRepo;

    @Override
    public List<Color> getAll() {
        return colorRepo.findAll();
    }

    @Override
    public Color getColorByID(Long id) {
        return colorRepo.findById(id).get();
    }

    @Override
    public void save(Color color) {
        colorRepo.save(color);
    }

    @Override
    public boolean existByColor(String color) {
        return colorRepo.existsByColor(color);
    }
}
