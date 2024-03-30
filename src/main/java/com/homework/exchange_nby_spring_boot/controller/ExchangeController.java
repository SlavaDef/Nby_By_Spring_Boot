package com.homework.exchange_nby_spring_boot.controller;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import com.homework.exchange_nby_spring_boot.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.homework.exchange_nby_spring_boot.Util.getByTwoMonth2;

@RequiredArgsConstructor
@RequestMapping("/")
@RestController
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping("/init")  // http://localhost:8080/init -> postman
    public void inIt() throws IOException {
        getByTwoMonth2(exchangeService);
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        Iterable<ExchangeCourse> courses = exchangeService.findAll();
        model.addAttribute("noteList", courses);
        return "note-all";
    }




}
