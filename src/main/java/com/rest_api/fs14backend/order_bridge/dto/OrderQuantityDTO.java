package com.rest_api.fs14backend.order_bridge.dto;
import lombok.Data;

import java.util.UUID;

/*public record OrderQuantityDTO(UUID albumId,Integer quantity, UUID orderId) {


}*/

/*public interface OrderQuantityDTO {
    UUID albumId();
    Integer quantity();

    UUID orderId();
}*/

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