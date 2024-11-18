package com.snapmart.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)


public class OrderRequest {

    String customerEmail;
    List<ItemRequest> itemRequestList;
    String shippingAddress;
    String billingAddress;
   // long totalAmount;
    int discountApplied;
}
