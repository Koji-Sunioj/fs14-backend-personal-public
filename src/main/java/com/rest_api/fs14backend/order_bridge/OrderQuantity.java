package com.rest_api.fs14backend.order_bridge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderQuantity {

    @EmbeddedId
    OrderQuantityKey orderKey;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    @JsonIgnore
    Order order;

    @ManyToOne
    @MapsId("album_id")
    @JoinColumn(name = "album_id")
    @JsonIgnore
    Album album;

    private Integer quantity;
}