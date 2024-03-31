package com.homework.exchange_nby_spring_boot.controller;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import com.homework.exchange_nby_spring_boot.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
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

    @PostMapping("/initEur")  // http://localhost:8080/initEur -> postman TO DO
    public void inItEur() throws IOException {
        getEurByTwoMonth(exchangeService);
    }

    @GetMapping("/list") // http://localhost:8080/list -> postman
    public List<ExchangeCourse> getAll() { // http://localhost:8080/list -> postman returns list of courses in postman
        return exchangeService.findAll();
    }

    // Аннотация @PathVariable используется для связывания значений из URL с параметрами метода

    @GetMapping("/dateOf/{year}/{month}/{day}") // http://localhost:8080/dateOf/2024/1/20 -> postman
    public ExchangeCourse courseByDate(@PathVariable int year,
                                       @PathVariable int month, @PathVariable int day) {
        //if(exchangeService.){
        //   response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        //       return DeleteUserResponse.failed(DeleteUserResponse.Error.userNotFound);
        //    }
        return exchangeService.searchByDate(year, month, day);
    }

    @SneakyThrows
    @GetMapping("/exchange/id/{id}")
    public ExchangeCourse getById(@PathVariable("id") Long id) {
        return exchangeService.getById(id);
    }

    // //http://localhost:8080/dateOfMax/2024/1/20/2024/2/20
    @GetMapping("/dateOfMax/{year}/{month}/{day}/{year2}/{month2}/{day2}")
    public double maxCourseByDates(@PathVariable int year,
                                @PathVariable int month, @PathVariable int day, @PathVariable int year2,
                                @PathVariable int month2, @PathVariable int day2) {

        return exchangeService.maxCourseByDate(year, month, day, year2, month2, day2);
    }
    @GetMapping("/dateOfMin/{year}/{month}/{day}/{year2}/{month2}/{day2}")
    public double minCourseByDates(@PathVariable int year,
                                @PathVariable int month, @PathVariable int day, @PathVariable int year2,
                                @PathVariable int month2, @PathVariable int day2) {

        return exchangeService.minCourseByDate(year, month, day, year2, month2, day2);
    }

    @GetMapping("/dateOfAvg/{year}/{month}/{day}/{year2}/{month2}/{day2}")
    public double avgCourseByDates(@PathVariable int year,
                                   @PathVariable int month, @PathVariable int day, @PathVariable int year2,
                                   @PathVariable int month2, @PathVariable int day2) {

        return exchangeService.avgCourseByDate(year, month, day, year2, month2, day2);
    }

}
