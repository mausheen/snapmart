package com.snapmart.model;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.snapmart.enums.AccountStatus;
import com.snapmart.enums.Gender;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SELLER")
@Builder
public class Seller {
/*SellerID: Unique identifier for the seller.
CompanyName: Name of the seller's business.
Email: Contact email.
Password: Encrypted password.
PhoneNumber: Seller’s contact number.
BusinessAddress: Seller’s business address.
BankDetails: Bank account details for receiving payments.
ProductList: List of products the seller offers.
Rating: Average rating from customers.
SalesHistory: Record of sales made.
AccountStatus: Active, suspended, etc.*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SELLER_ID")
	private int id;
	
	@Column(name="SELLER_COMPANY_NAME",nullable=false,unique = true)
	private String companyName;
	
	@Column(name="SELLER_EMAIL",nullable=false,unique = true)
	private String email;
	
	@Column(name="SELLER_PHONE",nullable=false,unique = true)
	private String phone;
	
	@Column(name="SELLER_ADDRESS")
	private String businessAddress;
	
	@Column(name="BANK_DETAILS")
	private String bankDetails;
	
	
	@Column(name="PRODUCT_RATING")
	private double rating;
	
	@Column(name="SELLER_ACCOUNT_STATUS")
	@Enumerated(value=EnumType.STRING)
	private AccountStatus accountStatus;
	
	 @Column(name="SELLER_GENDER")
	 @Enumerated(value = EnumType.STRING)
	 private Gender gender;
	
	//===================================================================================
	

	@OneToMany(mappedBy="seller",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> productList=new ArrayList<>();
	
	
	@OneToMany(mappedBy="seller",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Orders> ordertList=new ArrayList<>();
	
}
