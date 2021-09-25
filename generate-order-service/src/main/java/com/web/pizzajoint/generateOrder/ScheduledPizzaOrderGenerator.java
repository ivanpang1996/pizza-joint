package com.web.pizzajoint.generateOrder;

import com.web.pizzajoint.app.OrderItemAJAXView;
import com.web.pizzajoint.order.CreateOrderAJAXRequest;
import com.web.pizzajoint.order.CreateOrderAJAXResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ScheduledPizzaOrderGenerator {
    @Value("${order-service.url}")
    private String orderServiceURL;

    @Scheduled(cron = "*/10 * * * * *")
    public void generate() {
        var request = new CreateOrderAJAXRequest();
        request.customerName = "bot-" + UUID.randomUUID();
        request.orderItems = items();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(orderServiceURL + "/api/order", request, CreateOrderAJAXResponse.class);
    }

    private List<OrderItemAJAXView> items() {
        List<OrderItemAJAXView> items = new ArrayList<>();
        int min = 1;
        int max = 10;

        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        for (int i = 0; i < random_int; i++) {
            var item = new OrderItemAJAXView();
            item.itemName = "pizza";
            item.amount = BigDecimal.TEN;
            item.quantity = 3;
            items.add(item);
        }
        return items;
    }
}
