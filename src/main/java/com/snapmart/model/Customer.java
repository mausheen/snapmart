package com.snapmart.model;




import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.snapmart.enums.AccountStatus;
import com.snapmart.enums.Gender;

//import java.util.List;

//import com.snapmart.enums.AccountStatus;
import com.snapmart.enums.PaymentInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="CUSTOMER")
@Builder

public class Customer {
	/*CustomerID: Unique identifier for the customer.
Name: Customer's full name.
Email: Customer's email address.
Password: Customer's encrypted password.
PhoneNumber: Contact number.
ShippingAddress: Address for delivery.
BillingAddress: Payment billing address.
PaymentInfo: Payment method details (e.g., credit card, PayPal).
OrderHistory: List of past orders.
wishList: List of products the customer wants to purchase later.
AccountStatus: Indicates whether the account is active, suspended*/

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CUSTOMER_ID")	
	private int id;
	
	 @Column(name="CUSTOMER_NAME", nullable=false,unique=true)
	private String name;
	 
	 @Column(name="CUSTOMER_EMAIL", nullable=false,unique=true)
	private String email;
	 
	 @Column(name="CUSTOMER_PASSWORD", nullable=false)
	private String password;
	 
	 @Column(name="CUSTOMER_PHONE", nullable=false,unique=true)
	private String phone;
	 
	 @Column(name="CUSTOMER_SHIPPING_ADDRESS", nullable=false)
	private String shippingAddress;
	 
	 @Column(name="CUSTOMER_BILLING_ADDRESS", nullable=false)
	private String billingAddress;
	 
	 @Column(name="CUSTOMER_PAYMENT_INFO", nullable=false)
     @Enumerated(value = EnumType.STRING)
	private PaymentInfo paymentInfo;
	 
	 @Column(name="CUSTOMER_GENDER")
	 @Enumerated(value = EnumType.STRING)
	 private Gender gender;
	
	 
	 @Column(name="ACCOUNT_STATUS",nullable=false)
	 @Enumerated(value = EnumType.STRING)
	 private AccountStatus accountStatus;
	
	//===============================================================

	 @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	 @JsonIgnore
	 private List<Orders> orderHistory=new ArrayList<>();
	 


	
	
	
	
}
