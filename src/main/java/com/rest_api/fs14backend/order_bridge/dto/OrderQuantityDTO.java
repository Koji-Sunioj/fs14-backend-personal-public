package com.rest_api.fs14backend.order_bridge.dto;
import java.util.UUID;

public record OrderQuantityDTO(UUID albumId,Integer quantity, UUID orderId) {


}
