package com.homework.exchange_nby_spring_boot.service;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;

public interface ExchangeNbyRepo extends JpaRepository<ExchangeCourse, Long> {

    //  @Modifying// вказуємо спрінгу що модифікуємо змінюємо данні
    @Query(value = "from ExchangeCourse e where e.exchangedate = :exchangedate")
    ExchangeCourse courseByDate(@Param("exchangedate") LocalDate date);

    @Query(value = "SELECT max (c.rate) FROM ExchangeCourse c WHERE c.exchangedate >= :from AND c.exchangedate <= :to")
    double maxCourseByDate(@Param("from") LocalDate date, @Param("to") LocalDate date2);

    @Query(value = "SELECT min (c.rate) FROM ExchangeCourse c WHERE c.exchangedate >= :from AND c.exchangedate <= :to")
    double minCourseByDate(@Param("from") LocalDate date, @Param("to") LocalDate date2);

    @Query(value = "SELECT avg (c.rate) FROM ExchangeCourse c WHERE c.exchangedate >= :from AND c.exchangedate <= :to")
    double avgCourseByDate(@Param("from") LocalDate date, @Param("to") LocalDate date2);
}

