package com.homework.exchange_nby_spring_boot.models;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@NamedQueries({
        @NamedQuery(name = "ExchangeCourse_By_Date",
                query = "from ExchangeCourse e where e.exchangedate = :exchangedate"),
        @NamedQuery(name = "ExchangeCourse_By_MAX",
                query = "SELECT max (c.rate) FROM ExchangeCourse c WHERE c.exchangedate >= :from AND c.exchangedate <= :to"),
        @NamedQuery(name = "ExchangeCourse_By_MIN",
                query = "SELECT min (c.rate) FROM ExchangeCourse c WHERE c.exchangedate >= :from AND c.exchangedate <= :to"),
        @NamedQuery(name = "ExchangeCourse_By_AVG",
                query = "SELECT avg (c.rate) FROM ExchangeCourse c WHERE c.exchangedate >= :from AND c.exchangedate <= :to")
} )



@NoArgsConstructor
@Data
@Entity
public class ExchangeCourse {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ToString.Exclude
    private String txt;
    @JsonIgnore
    private String r030;
    private double rate;

    private String cc;
    @Temporal(value = TemporalType.DATE)
    //  @JsonFormat(pattern = "dd.MM.yyyy")
    private Date exchangedate;

    public ExchangeCourse(String txt, double rate, String cc, Date exchangedate) {
        this.txt = txt;
        this.rate = rate;
        this.cc = cc;
        this.exchangedate = exchangedate;
    }

    public ExchangeCourse(double rate, String cc, Date exchangedate) {
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

