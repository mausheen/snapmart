package com.snapmart.transformer;

import com.snapmart.dto.request.ProductRequest;
import com.snapmart.dto.response.ProductResponse;
import com.snapmart.enums.ProductCategory;
import com.snapmart.enums.ProductStatus;
import com.snapmart.model.Product;

public class ProductTransformer {

    public static Product productRequestToProduct(ProductRequest productRequest){

        return Product.builder()

                .productImages(productRequest.getProductImages())
                .price(productRequest.getPrice())
                .name(productRequest.getName())
                .rating(productRequest.getRating())
                .stock(productRequest.getStock())
                .reviews(productRequest.getReviews())
                .description(productRequest.getDescription())
                .discount(productRequest.getDiscount())
                .productCategory(ProductCategory.ACCESSORIES)
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponse productToProductResponse(Product product){

        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .discount(product.getDiscount())
                .dateAdded(product.getDateAdded())
                .build();
    }
}
