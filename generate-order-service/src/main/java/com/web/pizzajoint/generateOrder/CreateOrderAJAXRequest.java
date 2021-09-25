package com.web.pizzajoint.generateOrder;

import com.web.pizzajoint.order.domain.OrderItem;

import java.util.List;

public class CreateOrderAJAXRequest {
    public String customerName;

    public List<OrderItem> orderItems;
}
