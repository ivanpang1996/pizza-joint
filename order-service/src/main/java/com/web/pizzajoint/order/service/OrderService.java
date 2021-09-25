package com.web.pizzajoint.order.service;

import com.web.pizzajoint.order.domain.Orders;
import com.web.pizzajoint.order.repository.OrderRepository;
import com.web.pizzajoint.utils.JSONMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public CreateOrderResponse create(CreateOrderRequest request) {
        var order = new Orders();
        order.id = UUID.randomUUID().toString();
        order.customerName = request.customerName;
        order.orderItems = JSONMapper.toJSON(request.orderItems);
        order.totalPrice = request.totalPrice;
        order.createdTime = LocalDateTime.now();
        orderRepository.save(order);
        var response = new CreateOrderResponse();
        response.success = true;
        return response;
    }
}
