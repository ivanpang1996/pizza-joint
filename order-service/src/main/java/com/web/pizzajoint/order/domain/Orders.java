package com.web.pizzajoint.order.domain;

import com.fasterxml.jackson.core.type.TypeReference;
import com.web.pizzajoint.utils.JSONMapper;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {
    @Id
    public String id;

    @Column(nullable = true)
    public String customerName;

    @Column(nullable = false)
    public BigDecimal totalPrice;

    @Column(length = 1500, nullable = false)
    public String orderItems;

    @Column(nullable = false)
    public LocalDateTime createdTime;

    public List<OrderItem> orderItems() {
        return JSONMapper.fromJSON(orderItems, new TypeReference<List<OrderItem>>() {});
    }
}