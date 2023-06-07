package com.rest_api.fs14backend.order_bridge.dto;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderQuantityDTO{
    private UUID albumId;
    private Integer quantity;
    private UUID orderId;

    public OrderQuantityDTO(UUID albumId,Integer quantity, UUID orderId)
    {
        this.albumId=albumId;
        this.quantity=quantity;
        this.orderId=orderId;
    }

}