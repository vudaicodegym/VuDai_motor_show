package com.example.vudai_motor_show.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Model model;

    @NotNull
    @Min(0)
    private Double price;

    @NotNull
    @Min(0)
    private Long inventory;
}
