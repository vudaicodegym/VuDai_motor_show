package com.example.vudai_motor_show.repository;

import com.example.vudai_motor_show.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepo extends JpaRepository<Customers, Long> {
}
