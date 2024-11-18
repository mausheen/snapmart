package com.snapmart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SellerResponse {
    private String companyName;
    private String email;
    private String phone;
    private String businessAddress;
}
