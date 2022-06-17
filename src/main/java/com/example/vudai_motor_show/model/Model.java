package com.example.vudai_motor_show.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double cylinderCapacity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private  Brand brand;

    @ManyToOne Color color;
}
