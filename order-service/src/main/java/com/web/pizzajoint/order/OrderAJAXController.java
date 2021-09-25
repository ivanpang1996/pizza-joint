package com.web.pizzajoint.order;

import com.web.pizzajoint.app.OrderItemAJAXView;
import com.web.pizzajoint.order.domain.OrderItem;
import com.web.pizzajoint.order.service.CreateOrderRequest;
import com.web.pizzajoint.order.service.CreateOrderResponse;
import com.web.pizzajoint.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderAJAXController {
    @Autowired
    OrderService orderService;

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "";
    }

    @PostMapping("/api/order")
    public com.web.pizzajoint.order.CreateOrderAJAXResponse create(@RequestBody com.web.pizzajoint.order.CreateOrderAJAXRequest request) {
        BigDecimal totalPrice = totalPriceCalculator(request.orderItems);
        var orderRequest = new CreateOrderRequest();
        orderRequest.customerName = request.customerName;
        orderRequest.orderItems = orderItem(request.orderItems);
        orderRequest.totalPrice = totalPrice;
        CreateOrderResponse orderResponse = orderService.create(orderRequest);

        var response = new com.web.pizzajoint.order.CreateOrderAJAXResponse();
        response.success = orderResponse.success;
        return response;
    }

    private List<OrderItem> orderItem(List<OrderItemAJAXView> orderItems) {
        return orderItems.stream().map(view -> {
            var item = new OrderItem();
            item.itemName = view.itemName;
            item.amount = view.amount;
            item.quantity = view.quantity;
            return item;
        }).collect(Collectors.toList());
    }

    private BigDecimal totalPriceCalculator(List<OrderItemAJAXView> orderItems) {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (OrderItemAJAXView item : orderItems) {
            totalPrice = totalPrice.add(item.amount.multiply(BigDecimal.valueOf(item.quantity)));
        }
        return totalPrice;
    }
}
