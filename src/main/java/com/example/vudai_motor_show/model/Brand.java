package com.example.vudai_motor_show.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NaturalId(mutable = true)
    private String brandName;

    private String logo;

    // TODO: 6/18/2022: đặt ràng buộc không trùng nhau cho trường name của các bảng brand, category, color, model.

}
