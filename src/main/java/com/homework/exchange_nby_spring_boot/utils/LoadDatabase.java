package com.homework.exchange_nby_spring_boot.utils;

import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import com.homework.exchange_nby_spring_boot.service.ExchangeNbyRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ExchangeNbyRepo repository) {

        return args -> {
            log.info("Preloading " + repository.save(new ExchangeCourse(0.33, "Test 1", LocalDate.now())));
            log.info("Preloading " + repository.save(new ExchangeCourse(0.44, "Test 2",
                    LocalDate.of(2024,2,15))));
        };
    }
}
