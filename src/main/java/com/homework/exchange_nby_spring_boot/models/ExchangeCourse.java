package com.homework.exchange_nby_spring_boot.models;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@NoArgsConstructor
@Data
@Entity
public class ExchangeCourse {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ToString.Exclude
    @JsonIgnore
    private String txt;
    @JsonIgnore
    private String r030;
    private double rate;

    private String cc;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Temporal(value = TemporalType.DATE)
    private LocalDate exchangedate;

    public ExchangeCourse(double rate, String cc, LocalDate exchangedate) {
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    @Override
    public String toString() {
        return "ExchangeCourse{" +
                " rate=" + rate +
                ", cc='" + cc + '\'' +
                ", exchangedate=" + exchangedate +
                '}';
    }
}

