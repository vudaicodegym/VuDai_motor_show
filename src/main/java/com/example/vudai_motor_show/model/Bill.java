package com.example.vudai_motor_show.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
public class Bill {
    @Id
    private Long id;

    @ManyToOne
    @NotNull
    private Customers customer;

    @ManyToOne
    @NotNull
    private Model model;

    @NotNull
    private Double price;

    @NotNull
    private Date date;
}
