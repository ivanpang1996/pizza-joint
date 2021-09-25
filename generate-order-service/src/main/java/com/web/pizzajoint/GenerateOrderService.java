package com.web.pizzajoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GenerateOrderService {

    public static void main(String[] args) {
        SpringApplication.run(GenerateOrderService.class, args);
    }

}
