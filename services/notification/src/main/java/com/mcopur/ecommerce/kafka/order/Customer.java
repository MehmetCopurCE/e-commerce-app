package com.mcopur.ecommerce.kafka.order;

public record Customer(
        String id,
        String firsName,
        String lastName,
        String email
) {
}
