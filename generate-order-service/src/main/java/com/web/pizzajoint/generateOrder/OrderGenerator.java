package com.web.pizzajoint.generateOrder;

import com.web.pizzajoint.order.CreateOrderAJAXRequest;
import com.web.pizzajoint.order.CreateOrderAJAXResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderGenerator {
    @Value("${order-service.url}")
    private String orderServiceURL;

    @GetMapping("")
    public String welcome() {
        return "welcome to pizza joint.";
    }

    @PostMapping("/order")
    public CreateOrderAJAXResponse generate(@RequestBody CreateOrderAJAXRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(orderServiceURL + "/api/order", request, CreateOrderAJAXResponse.class);
    }
}
