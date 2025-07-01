package com.mcopur.ecommerce.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,
        @NotNull(message = "FirstName is required")
        String firsName,
        @NotNull(message = "LastName is required")
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "The customer email is not correctly formatted")
        String email
) {
}
