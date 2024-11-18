
package com.snapmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.snapmart.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
