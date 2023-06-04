package com.rest_api.fs14backend.order.dto;
import com.rest_api.fs14backend.order_bridge.dto.OrderQuantityDTO;

import java.util.List;
import java.util.UUID;

public interface OrderDTO {
    UUID userId();
    List<OrderQuantityDTO> albums();

}