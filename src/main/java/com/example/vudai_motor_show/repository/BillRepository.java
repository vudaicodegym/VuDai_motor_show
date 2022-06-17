package com.example.vudai_motor_show.repository;

import com.example.vudai_motor_show.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
