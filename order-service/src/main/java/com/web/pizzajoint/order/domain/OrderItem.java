package com.web.pizzajoint.order.domain;

import javax.persistence.Column;
import java.math.BigDecimal;

public class OrderItem {
    @Column(nullable = false)
    public String itemName;

    @Column(nullable = false)
    public Integer quantity;

    @Column(nullable = false)
    public BigDecimal amount;
}
