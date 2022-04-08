package com.omfine.day;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.omfine.day.mapper")
public class DayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DayApplication.class, args);
    }

}
