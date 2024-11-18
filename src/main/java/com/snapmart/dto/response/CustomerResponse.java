package com.snapmart.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CustomerResponse {
    String name;
    String email;
    String billingAddress;
    String shippingAddress;
}
