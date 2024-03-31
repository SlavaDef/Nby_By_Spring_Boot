package com.homework.exchange_nby_spring_boot.service;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ExchangeService {

private final ExchangeNbyRepo repo;

    public ExchangeService(ExchangeNbyRepo repo) {
        this.repo = repo;
    }

    public void addExchange(ExchangeCourse exchangeCourse){
        repo.save(exchangeCourse);
    }

    public List<ExchangeCourse> findAll(){
        return repo.findAll();
    }

    public ExchangeCourse getById(Long id) throws ChangeSetPersister.NotFoundException {
        return repo.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public ExchangeCourse searchByDate(int year, int month, int day) {
        //return repo.courseByDate("%" + date + "%");
        return repo.courseByDate(LocalDate.of(year,month,day));

    }

    public double maxCourseByDate(int year, int month, int day, int year2,int month2,int day2){
        return repo.maxCourseByDate(LocalDate.of(year,month,day),LocalDate.of(year2,month2,day2));
    }

    public double minCourseByDate(int year, int month, int day, int year2,int month2,int day2){
        return repo.minCourseByDate(LocalDate.of(year,month,day),LocalDate.of(year2,month2,day2));
    }

    public double avgCourseByDate(int year, int month, int day, int year2,int month2,int day2){
        return repo.avgCourseByDate(LocalDate.of(year,month,day),LocalDate.of(year2,month2,day2));
    }

}
