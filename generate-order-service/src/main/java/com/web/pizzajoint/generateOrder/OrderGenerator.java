package com.web.pizzajoint.generateOrder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class OrderGenerator {

    @GetMapping("/order")
    public void generate() {

    }

}
