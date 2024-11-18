package com.snapmart.controller;

import com.snapmart.dto.request.SellerRequest;
import com.snapmart.dto.response.SellerResponse;
import com.snapmart.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SellerController {

    @Autowired
    SellerService sellerService;


    @PostMapping("/seller")
    public SellerResponse setSeller(@RequestBody SellerRequest sellerRequest){
        return sellerService.setSeller(sellerRequest);
    }
}
