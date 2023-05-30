package com.rest_api.fs14backend.order_bridge;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderQuantityRepository extends JpaRepository<OrderQuantity, OrderQuantityKey> {

}