package com.mcopur.ecommerce.orderline;

import com.mcopur.ecommerce.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    OrderLine order(Order order);

    List<OrderLine> findAllByOrderId(Integer orderId);
}
