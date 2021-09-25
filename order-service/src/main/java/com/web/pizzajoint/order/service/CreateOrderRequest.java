package com.web.pizzajoint.order.service;

import com.web.pizzajoint.order.domain.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class CreateOrderRequest {
    public String customerName;

    public List<OrderItem> orderItems;

    public BigDecimal totalPrice;
}
