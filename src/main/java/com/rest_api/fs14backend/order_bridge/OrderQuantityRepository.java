package com.rest_api.fs14backend.order_bridge;

import com.rest_api.fs14backend.album.AlbumWODTO;
import com.rest_api.fs14backend.order_bridge.OrderQuantity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface OrderQuantityRepository extends JpaRepository<OrderQuantity, OrderQuantityKey> {

}