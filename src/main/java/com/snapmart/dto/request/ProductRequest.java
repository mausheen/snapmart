package com.snapmart.dto.request;

import com.snapmart.enums.ProductCategory;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductRequest {

    private String name;
    private String description;
    private int price;
    private int stock;
    private String productImages;
    private double rating;
    private String reviews;
    private int discount;

}
