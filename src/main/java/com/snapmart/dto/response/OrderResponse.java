package com.snapmart.dto.response;

import com.snapmart.enums.OrderStatus;
import com.snapmart.enums.ShippingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {


    Date orderDate;
    String shippingAddress;
    String billingAddress;
    long totalAmount;
    ShippingStatus shippingStatus;
    OrderStatus orderStatus;
    String trackingNumber;
    Date estimatedDelivery;
    CustomerResponse customer;
    List<ProductResponse> productResponseList;
}
