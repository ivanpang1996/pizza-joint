package com.web.pizzajoint.order;

import com.web.pizzajoint.app.OrderItemAJAXView;

import java.util.List;

public class CreateOrderAJAXRequest {
    public String customerName;

    public List<OrderItemAJAXView> orderItems;
}
