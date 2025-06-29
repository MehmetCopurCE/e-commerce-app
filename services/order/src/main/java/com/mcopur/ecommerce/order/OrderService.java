package com.mcopur.ecommerce.order;

import com.mcopur.ecommerce.customer.CustomerClient;
import com.mcopur.ecommerce.exception.BusinessException;
import com.mcopur.ecommerce.orderline.OrderLineRequest;
import com.mcopur.ecommerce.orderline.OrderLineService;
import com.mcopur.ecommerce.product.ProductClient;
import com.mcopur.ecommerce.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        // check the customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exist with the provided ID"));

        // purchase the product --> product-ms (RestTemplate)
        this.productClient.purchaseProducts(request.products());

        //persist order
        var order = this.repository.save(mapper.toOrder(request));

        //persist order lines
        for (PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // todo start payment process

        //send the order confirmation --> notification-ms (kafka)

        return null;
    }
}
