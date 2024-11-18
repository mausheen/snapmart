package com.snapmart.dto.request;

import com.snapmart.model.Customer;

import lombok.AllArgsConstructor;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class CustomerRequest {
	
	 String name;
	 
	 
	 String email;
	 
	 
	 String password;
	 
	
	 String phone;
	 

	 String shippingAddress;
	 
	 
	 String billingAddress;

}
