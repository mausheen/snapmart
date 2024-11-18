package com.snapmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snapmart.model.Seller;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
    public Optional<Seller> findByEmail(String email);
}
