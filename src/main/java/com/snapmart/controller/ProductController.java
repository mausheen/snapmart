package com.snapmart.controller;


import com.snapmart.dto.request.ProductRequest;
import com.snapmart.dto.response.ProductResponse;
import com.snapmart.exceptions.SellerNotFoundException;
import com.snapmart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity setProduct(@RequestBody ProductRequest productRequest, @RequestParam("seller-email") String email){

        try {
            return new ResponseEntity(productService.setProduct(productRequest, email), HttpStatus.CREATED);
        }
        catch (SellerNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
