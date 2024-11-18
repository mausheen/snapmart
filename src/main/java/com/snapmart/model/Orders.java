
package com.snapmart.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.snapmart.enums.OrderStatus;
import com.snapmart.enums.PaymentInfo;
import com.snapmart.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ORDERS")
public class Orders {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDERS_ID")
	private int id;

	@Column(name="ORDERS_SHIPP_ADDRESS")
	private String shippingAddress;
	
	@Column(name="ORDERS_BILL_ADDRESS")
	private String billingAddress;
	
	@Column(name="ORDERS_TOTAL_AMOUNT")
	private long totalAmount;

	@Column(name="ORDERS_DISCOUNT")
	private int discountApplied;
	
	@Column(name="ORDERS_PAYMENT_METHOD")
	@Enumerated(value = EnumType.STRING)
	private PaymentInfo paymentMethod;

	@Column(name="ORDERS_STATUS")
	@Enumerated(value = EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Column(name="ORDERS_TRACKIN_NUMBER")
	private String trackingNumber;
//=========================================//

	@Column(name="ORDERS_DATE")
	@CreationTimestamp
	private Date orderDate;

	@Column(name="ORDERS_SHIPP_ADDRESS_STATUS")
	@Enumerated(value = EnumType.STRING)
	private ShippingStatus shippingStatus;

	@Column(name="ORDERS_DELIVER_DATE")
	@CreationTimestamp
	private Date estimatedDelivery;
	
	//=====================================================
	
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="SELLER_ID")
	@JsonIgnore
	private Seller seller;
	
	@ManyToMany(mappedBy = "orderList")
	@JsonIgnore
	private List<Product> productList=new ArrayList<>();
}


/* OrderID: Unique identifier for the order.
CustomerID: ID of the customer who placed the order.
OrderDate: Date the order was placed.
ShippingAddress: Delivery address for the order.
BillingAddress: Billing address for payment.
OrderItems: List of products in the order (each with quantity, price, etc.).
TotalAmount: Total amount for the order.
PaymentMethod: The method used to pay for the order (e.g., credit card, PayPal).
ShippingStatus: Status of the shipment (e.g., pending, shipped, delivered).
OrderStatus: Status of the order (e.g., processing, completed, canceled).
TrackingNumber: If applicable, for tracking the shipment.
SellerID: Seller associated with the order.
DiscountApplied: Discount applied to the order, if any.
EstimatedDelivery: Expected date of delivery. 


*/