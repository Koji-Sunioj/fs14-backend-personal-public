package com.rest_api.fs14backend.order_bridge;

import jakarta.persistence.Embeddable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;
import java.io.Serializable;

@Embeddable
@Data
class OrderQuantityKey implements Serializable {

    @Column(name = "order_id")
    UUID orderId;

    @Column(name = "album_id")
    UUID albumID;

}