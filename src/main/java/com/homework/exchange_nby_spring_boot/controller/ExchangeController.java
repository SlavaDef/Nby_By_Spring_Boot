package com.homework.exchange_nby_spring_boot.controller;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import com.homework.exchange_nby_spring_boot.service.ExchangeService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Query;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.homework.exchange_nby_spring_boot.utils.Util.getEurByTwoMonth;
import static com.homework.exchange_nby_spring_boot.utils.Util.getUsdByTwoMonth;

@RequiredArgsConstructor
//@RequestMapping("/")
@RestController
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping("/")  // http://localhost:8080/ -> postman , init db by coures of usd by 2 month
    public void inItUsd() throws IOException {
        getUsdByTwoMonth(exchangeService);
    }

    @PostMapping("/initEur")  // http://localhost:8080/init -> postman TO DO
    public void inItEur() throws IOException {
      //  getEurByTwoMonth(exchangeService);
    }

    @GetMapping("/list")
    public List<ExchangeCourse> getAll() { // http://localhost:8080/list -> postman returns list of courses in postman
       return exchangeService.findAll();
    }

    @GetMapping("/date/{date}")
    public ExchangeCourse courseByDate(@PathVariable("date") Long date){
      //  if(exchangeService.){
         //   response.setStatus(HttpServletResponse.SC_NOT_FOUND);
     //       return DeleteUserResponse.failed(DeleteUserResponse.Error.userNotFound);
    //    }
            return exchangeService.search(date);
    }

    //@GetMapping("/countOlderThan/{age}")
    //public int getCountPeopleAlderThen(@PathVariable("age") int age) {
     //   return userService.countPeopleOlderThen(age);
    //}






}
