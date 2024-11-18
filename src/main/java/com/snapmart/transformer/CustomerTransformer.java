package com.snapmart.transformer;

import com.snapmart.dto.request.CustomerRequest;
import com.snapmart.dto.response.CustomerResponse;
import com.snapmart.enums.AccountStatus;
import com.snapmart.enums.Gender;
import com.snapmart.enums.PaymentInfo;
import com.snapmart.model.Customer;
import lombok.Builder;

public class CustomerTransformer {

	public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {

		Customer customer=Customer.builder()
				.name(customerRequest.getName())
				.email(customerRequest.getEmail())
				.password(customerRequest.getPassword())
				.phone(customerRequest.getPhone())
				.shippingAddress(customerRequest.getShippingAddress())
				.billingAddress(customerRequest.getBillingAddress())
				.accountStatus(AccountStatus.ACTIVE)
				.paymentInfo(PaymentInfo.CREDIT_CARD)
				.gender(Gender.MALE)
				.build();

         return customer;
	}

	public static CustomerResponse customerToCustomerResponse(Customer customer){

		return CustomerResponse.builder()
				.name(customer.getName())
				.email(customer.getEmail())
				.billingAddress(customer.getBillingAddress())
				.shippingAddress(customer.getShippingAddress())
				.build();
	}

}
