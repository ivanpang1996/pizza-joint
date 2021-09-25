package com.web.pizzajoint.order.repository;

import com.web.pizzajoint.order.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, String> {
}
