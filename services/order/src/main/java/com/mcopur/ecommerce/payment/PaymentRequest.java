package com.mcopur.ecommerce.payment;

import com.mcopur.ecommerce.customer.CustomerResponse;
import com.mcopur.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
