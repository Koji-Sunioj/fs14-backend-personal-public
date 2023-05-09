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

    @OneToMany(mappedBy = "order")
    private List<OrderQuantity> purchases = new ArrayList<>();
}
