package com.homework.exchange_nby_spring_boot.service;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

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

    public ExchangeCourse search(Long date) {
        //return repo.courseByDate("%" + date + "%");
        return repo.courseByDate(new Date(date));

    }

}
