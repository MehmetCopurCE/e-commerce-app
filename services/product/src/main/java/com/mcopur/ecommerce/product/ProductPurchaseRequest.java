package com.mcopur.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "Product is mandotary")
        Integer productId,
        @Positive(message = "Quantity is mandotary")
        double quantity
) {
}
