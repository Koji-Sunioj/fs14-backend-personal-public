package com.rest_api.fs14backend.order.dto;
import com.rest_api.fs14backend.order_bridge.dto.OrderQuantityDTO;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
public class OrderDTO
{
    private UUID userId;
    private List<OrderQuantityDTO> albums;


    public  OrderDTO(UUID userId,List<OrderQuantityDTO> albums)
    {
        this.userId = userId;
        this.albums = albums;
    }

}