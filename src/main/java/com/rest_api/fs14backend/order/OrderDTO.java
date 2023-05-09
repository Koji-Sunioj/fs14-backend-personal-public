package com.rest_api.fs14backend.order;
import com.rest_api.fs14backend.order_bridge.OrderQuantity;
import com.rest_api.fs14backend.order_bridge.OrderQuantityDTO;

import java.util.List;
import java.util.UUID;

public record OrderDTO(UUID userId, List<OrderQuantityDTO> albums) {
}
