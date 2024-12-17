package com.example.sellinglaptops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SellingLaptopsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellingLaptopsApplication.class, args);
    }

}