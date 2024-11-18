package com.snapmart.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class SellerRequest {


    private String companyName;
    private String email;
    private String phone;
    private String businessAddress;
    private String bankDetails;
    private double rating;
}
