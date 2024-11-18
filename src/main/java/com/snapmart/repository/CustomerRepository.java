package com.snapmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snapmart.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

    Optional<Customer> findByEmail(String email);

}
