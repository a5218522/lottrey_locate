package com.example.lottrey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"lottery"})
public class LottreyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LottreyApplication.class, args);
    }

}
