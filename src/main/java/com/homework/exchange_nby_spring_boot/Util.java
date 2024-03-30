package com.homework.exchange_nby_spring_boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.exchange_nby_spring_boot.models.ExchangeCourse;
import com.homework.exchange_nby_spring_boot.service.ExchangeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

public class Util {

    public static void getByTwoMonth2(ExchangeService dao) throws IOException {
        int x = 0;
        String c = "1";
        int leng = 32;

        while (x < 2) {
            String a = "0";
            for (int i = 1; i < leng; i++) {
                if (i == 10) {
                    a = "";
                }
                String parse33 = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=20240" + c + a + i + "&json";
                URL url = new URL(parse33);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
                try (BufferedReader reader = new BufferedReader
                        (new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder result = new StringBuilder();
                    for (String line; (line = reader.readLine()) != null; ) {
                        result.append(line.replaceAll("]", "").replaceAll("\\[", ""));
                    }
                    ExchangeCourse course = objectMapper.readValue(result.toString(), ExchangeCourse.class);
                    dao.addExchange(new ExchangeCourse(course.getRate(),
                            course.getCc(), course.getExchangedate()));
                }
            }
            leng = 30;
            c = "2";
            x++;
        }
    }
}
