package com.rest_api.fs14backend.order;

import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.order_bridge.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.util.*;

@Entity
@Table(name="store_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name="order_id")
    private UUID orderId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    @JsonIgnore
    private User user;

    @CreationTimestamp
    @Column(insertable=false,name="purchased_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date purchasedAt;

    @OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE)
    private List<OrderQuantity> purchases;

    @Transient
    private Double total;

    @Transient
    private UUID userId;

    public UUID getUserId()
    {
        return this.user.getUserId();
    }

    public Double getTotal() {
        Double sum = 0.0;
        for (OrderQuantity o:purchases){
            sum += o.getAlbum().getPrice() * o.getQuantity();
        }
        return sum;
    }
}
