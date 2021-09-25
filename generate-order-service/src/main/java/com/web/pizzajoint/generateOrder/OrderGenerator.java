package com.web.pizzajoint.generateOrder;

import com.web.pizzajoint.order.CreateOrderAJAXRequest;
import com.web.pizzajoint.order.CreateOrderAJAXResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class OrderGenerator {

    @GetMapping("/order")
    public void generate() {
        final String uri = "http://order-service:8080/api/order";

        var request = new CreateOrderAJAXRequest();
        request.customerName = "gen";
        request.orderItems = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        CreateOrderAJAXResponse orderResponse = restTemplate.postForObject(uri, request, CreateOrderAJAXResponse.class);

        System.out.println(orderResponse.success);
    }

}
