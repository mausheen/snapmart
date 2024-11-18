package com.snapmart.transformer;

import com.snapmart.dto.request.OrderRequest;
import com.snapmart.dto.response.OrderResponse;
import com.snapmart.dto.response.ProductResponse;
import com.snapmart.enums.OrderStatus;
import com.snapmart.enums.PaymentInfo;
import com.snapmart.enums.ShippingStatus;
import com.snapmart.model.Orders;
import com.snapmart.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {

    public static Orders orderRequestToOrders(OrderRequest orderRequest,int totalValue){


        return Orders.builder()

                .shippingAddress(orderRequest.getShippingAddress())
                .billingAddress(orderRequest.getBillingAddress())
                .totalAmount(totalValue)
                .discountApplied(orderRequest.getDiscountApplied())
                .trackingNumber(String.valueOf(UUID.randomUUID()))
                .shippingStatus(ShippingStatus.PROCESSING)
                .orderStatus(OrderStatus.COMPLETED)
                .paymentMethod(PaymentInfo.PAYTM)
                .build();
    }


    //OrderTransformer.orderToOrderResponse(savedOrder);
    public static OrderResponse orderToOrderResponse(Orders orders){
        OrderResponse orderResponse= OrderResponse.builder()
                .billingAddress(orders.getBillingAddress())
                .orderStatus(OrderStatus.COMPLETED)
                .trackingNumber(orders.getTrackingNumber())
                .orderDate(orders.getOrderDate())
                .estimatedDelivery(orders.getEstimatedDelivery())
                .shippingAddress(orders.getShippingAddress())
                .shippingStatus(ShippingStatus.PROCESSING)
                .totalAmount(orders.getTotalAmount())

                .customer(CustomerTransformer.customerToCustomerResponse(orders.getCustomer()))
                .build();

        List<ProductResponse> productResponses = new ArrayList<>();
        for(Product product: orders.getProductList()) {
            productResponses.add(ProductTransformer.productToProductResponse(product));
        }

        orderResponse.setProductResponseList(productResponses);
        return orderResponse;
    }

}
