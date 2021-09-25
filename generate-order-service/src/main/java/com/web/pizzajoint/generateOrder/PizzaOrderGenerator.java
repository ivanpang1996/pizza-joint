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
public class PizzaOrderGenerator {
    @Value("${order-service.url}")
    private String orderServiceURL;

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "";
    }

    @GetMapping("")
    public String welcome() {
        return "welcome to pizza joint.";
    }

    @PostMapping("/order")
    public CreatePizzaOrderAJAXResponse generate(@RequestBody CreatePizzaOrderAJAXRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        var createRequest = new CreateOrderAJAXRequest();
        createRequest.customerName = request.customerName;
        createRequest.orderItems = request.orderItems;

        var response = new CreatePizzaOrderAJAXResponse();
        CreateOrderAJAXResponse orderResponse = restTemplate.postForObject(orderServiceURL + "/api/order", createRequest, CreateOrderAJAXResponse.class);
        if (orderResponse == null) {
            response.success = Boolean.FALSE;
            return response;
        }
        response.success = orderResponse.success;
        response.orderId = orderResponse.orderId;
        return response;
    }

}
