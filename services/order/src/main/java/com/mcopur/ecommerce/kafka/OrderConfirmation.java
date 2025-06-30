package com.mcopur.ecommerce.kafka;

import com.mcopur.ecommerce.customer.CustomerResponse;
import com.mcopur.ecommerce.order.PaymentMethod;
import com.mcopur.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
