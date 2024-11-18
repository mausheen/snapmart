package com.snapmart.service;

import com.snapmart.dto.request.CustomerRequest;
import com.snapmart.dto.response.CustomerResponse;
import com.snapmart.model.Customer;
import com.snapmart.repository.CustomerRepository;
import com.snapmart.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse setCustomer(CustomerRequest customerRequest){

       Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
       Customer saveCustomer=customerRepository.save(customer);
       CustomerResponse customerResponse= CustomerTransformer.customerToCustomerResponse(saveCustomer);

       return customerResponse;

    }

}
