package com.example.vudai_motor_show.service;

import com.example.vudai_motor_show.model.Color;

import java.awt.*;
import java.util.List;

public interface IColorService {
    List<Color> getAll();
    Color getColorByID(Long id);
    void save(Color color);
    boolean existByColor(String color);
}
