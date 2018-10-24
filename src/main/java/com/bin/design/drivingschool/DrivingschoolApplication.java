package com.bin.design.drivingschool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan()
public class DrivingschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrivingschoolApplication.class, args);
    }
}
