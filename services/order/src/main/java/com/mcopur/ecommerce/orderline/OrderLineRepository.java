package com.mcopur.ecommerce.orderline;

import com.mcopur.ecommerce.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    OrderLine order(Order order);
}
