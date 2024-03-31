package com.homework.exchange_nby_spring_boot.service;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

public interface ExchangeNbyRepo extends JpaRepository<ExchangeCourse, Long> {

  //  @Modifying// вказуємо спрінгу що модифікуємо змінюємо данні
    @Query( value = "from ExchangeCourse e where e.exchangedate = :exchangedate")
    ExchangeCourse courseByDate(@Param("exchangedate") Date date);



 //   @Query(nativeQuery = true, value = "DELETE FROM \"user\" WHERE email IN (:emails)")
  //  void deleteAllByEmails(@Param("emails") List<String> emails);

}

//@Query(nativeQuery = true, value
       // = "SELECT count(*) FROM \"user\" WHERE birthday < :maxBirthday")
//int countOlderThan(LocalDate maxBirthday);
