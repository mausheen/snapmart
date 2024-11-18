package com.snapmart.repository;

import com.snapmart.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snapmart.model.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>{



}
