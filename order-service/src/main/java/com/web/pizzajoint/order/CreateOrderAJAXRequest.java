package com.web.pizzajoint.order;


import java.util.List;

//TODO: share with generate order svc
public class CreateOrderAJAXRequest {
    public String customerName;

    public List<OrderItemAJAXView> orderItems;
}
