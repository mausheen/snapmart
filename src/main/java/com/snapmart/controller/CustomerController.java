package com.snapmart.controller;


import com.snapmart.dto.request.CustomerRequest;
import com.snapmart.dto.response.CustomerResponse;
import com.snapmart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/customer")
    public CustomerResponse setCustomer(@RequestBody CustomerRequest customerRequest){

        return customerService.setCustomer(customerRequest);
    }
}
