package com.homework.exchange_nby_spring_boot.service;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeNbyRepo extends JpaRepository<ExchangeCourse, Long> {
}
