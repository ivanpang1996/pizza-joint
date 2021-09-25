package com.web.pizzajoint.generateOrder;

import com.web.pizzajoint.app.OrderItemAJAXView;

import java.util.List;

public class CreatePizzaOrderAJAXRequest {
    public String customerName;

    public List<OrderItemAJAXView> orderItems;
}
