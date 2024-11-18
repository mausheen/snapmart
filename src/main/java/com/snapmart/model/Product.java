package com.snapmart.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.snapmart.enums.ProductCategory;


import com.snapmart.enums.ProductStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="PRODUCT")
@Builder


public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	 int id;
	
	@Column(name = "PRODUCT_NAME", nullable=false)
	String name;
	
	@Column(name = "PRODUCT_DISC", nullable=false)
	 String description;
	
	@Column(name = "PRODUCT_PRICE", nullable=false)
	 int price;

	@Column(name = "PRODUCT_STOCK", nullable=false)
	 int stock;

	@Column(name = "PRODUCT_CATEGORY", nullable=false)
	@Enumerated(value = EnumType.STRING)
	 ProductCategory productCategory;

	
	@Column(name="PRODUCT_IMAGE")
    String productImages;
	
	
	@Column(name="PRODUCT_RATING")
	 double rating;
	
	@Column(name="PRODUCT_REVIEWS")
	 String reviews;
	
	@Column(name="PRODUCT_ADDED_DATE")
	@CreationTimestamp
	 Date dateAdded;
	
	@Column(name="PROCUCT_DISCOUNT")
	 int discount;

	@Column(name="PRODUCT_STATUS")
	@Enumerated(value = EnumType.STRING)
	ProductStatus productStatus;
	//=======================================================================
	
	@ManyToOne
	@JoinColumn(name="SELLER_ID")
	@JsonIgnore
	private Seller seller;
 

	
	@ManyToMany
	@JsonIgnore
    @JoinTable(name="PRODUCT_ORDER",
    joinColumns = @JoinColumn(name="PRODUCT_ID"),
    inverseJoinColumns = @JoinColumn(name="ORDER_ID"))
	private List<Orders> orderList=new ArrayList<>();
	
}
/*ProductID: Unique identifier for the product.
Name: Name of the product.
Description: Detailed description of the product.
Price: Price of the product.
Category: The category the product falls under (e.g., electronics, clothing).
Stock: Quantity available.
SellerID: ID of the seller who listed the product.
ProductImages: Array of images showCasing the product.
Rating: Average rating from customers.
Reviews: List of customer reviews.
DateAdded: Date the product was added to the catalog.
Discount: Any discount currently applied.*/