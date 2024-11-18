package com.snapmart.service;

import com.snapmart.dto.request.ItemRequest;
import com.snapmart.dto.request.OrderRequest;
import com.snapmart.dto.response.OrderResponse;
import com.snapmart.enums.ProductStatus;
import com.snapmart.exceptions.CustomerNotFoundException;
import com.snapmart.exceptions.ProductNotAvailableException;
import com.snapmart.model.Customer;
import com.snapmart.model.Orders;
import com.snapmart.model.Product;
import com.snapmart.model.Seller;
import com.snapmart.repository.CustomerRepository;
import com.snapmart.repository.OrderRepository;
import com.snapmart.repository.ProductRepository;
import com.snapmart.repository.SellerRepository;
import com.snapmart.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Optional<Customer> customerOptional = customerRepository.findByEmail(orderRequest.getCustomerEmail());
        if(customerOptional.isEmpty()) {
            throw new CustomerNotFoundException("Email is not valid");
        }

        Customer customer = customerOptional.get();

        List<Product> productsRequested = new ArrayList<>();
        int totalValue = 0;
        Seller seller= new Seller();
        for(ItemRequest itemRequest: orderRequest.getItemRequestList()) {
            Optional<Product> optionalProduct = productRepository.findById(itemRequest.getId());

            if(optionalProduct.isEmpty()) {
                throw new ProductNotAvailableException("Sorry, the product id=" + itemRequest.getId()+" is invalid");
            }
            Product product = optionalProduct.get();
            seller=product.getSeller();

            if(product.getStock() < itemRequest.getRequiredQuantity()) {
                throw new ProductNotAvailableException("Sorry, the product with id = "+product.getId()+" is out of stock");
            }

            product.setStock(product.getStock()-itemRequest.getRequiredQuantity());
            if(product.getStock()==0) {
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
            totalValue += itemRequest.getRequiredQuantity()*product.getPrice();
           totalValue=totalValue-orderRequest.getDiscountApplied();

            productsRequested.add(product);
        }

        // complete the order entity and save it
        Orders order = OrderTransformer.orderRequestToOrders(orderRequest,totalValue);

        order.setCustomer(customer);
        order.setSeller(seller);


        order.setProductList(productsRequested);
        Orders savedOrder = orderRepository.save(order);

        // complete product and customer entity and save them as well
        for(Product product: productsRequested) {
            product.getOrderList().add(savedOrder);
        }

        customer.getOrderHistory().add(savedOrder);
        //save customer and product
        customerRepository.save(customer); // customer + order;
        productRepository.saveAll(productsRequested);

        // send email
        sendEmail(savedOrder);



        // return the response;
        return OrderTransformer.orderToOrderResponse(savedOrder);
    }

    private void sendEmail(Orders savedOrder) {
        String text = "Hi " + savedOrder.getCustomer().getName() + " your order is placed with total value = "+ savedOrder.getTotalAmount();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mmausheen3654@gmail.com");
        message.setTo(savedOrder.getCustomer().getEmail());
        message.setSubject("Order Placed");
        message.setText(text);
        javaMailSender.send(message);
    }
}
