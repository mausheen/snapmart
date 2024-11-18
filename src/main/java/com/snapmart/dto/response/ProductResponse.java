package com.snapmart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponse {

    private String name;
    private int price;
    private int stock;
    private int discount;
    private Date dateAdded;
}
