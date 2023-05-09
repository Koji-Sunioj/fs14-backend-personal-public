package com.rest_api.fs14backend.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.util.*;

@Entity
@Table(name="store_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name="user_id")
    private UUID userId;

    @JsonIgnore
    @OneToMany(mappedBy="user")
    private List<Order> orders = new ArrayList<>();

    @Column(name="email",length=50,unique=true)
    private String email;

    @CreationTimestamp
    @Column(insertable=false,name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

}
