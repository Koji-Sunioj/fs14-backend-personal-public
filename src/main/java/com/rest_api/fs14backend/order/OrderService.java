package com.rest_api.fs14backend.order;

import com.rest_api.fs14backend.album.Album;
import com.rest_api.fs14backend.album.AlbumRepository;
import com.rest_api.fs14backend.order.dto.OrderDTO;
import com.rest_api.fs14backend.order_bridge.OrderQuantity;
import com.rest_api.fs14backend.order_bridge.OrderQuantityKey;
import com.rest_api.fs14backend.order_bridge.OrderQuantityRepository;
import com.rest_api.fs14backend.user.User;
import com.rest_api.fs14backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    OrderQuantityRepository orderQuantityRepository;

    @Autowired
    UserService userService;
    public List<Order> getOrders()
    {
        return orderRepository.findAll();
    }

    public Order getOrder(UUID orderId)
    {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order createOrder(OrderDTO newOrder) {
        Order createdOrder = null;
        List<Album> albums = new ArrayList<>();
        List<Boolean> isInStock = new ArrayList<>();
        newOrder.getAlbums().forEach((temp) -> {
            Album requestedAlbum = albumRepository.findById(temp.getAlbumId()).orElse(null);
            if (requestedAlbum.getStock() < temp.getQuantity() || requestedAlbum.getStock() == 0) {
                isInStock.add(false);
            } else {
                isInStock.add(true);
                albums.add(requestedAlbum);
            }
        });
        Set<Boolean> checks = new HashSet<Boolean>(isInStock);
        if (checks.contains(false) == false) {
            createdOrder = new Order();
            User existingUser = userService.getUser(newOrder.getUserId());
            createdOrder.setUser(existingUser);
            Order dbOrder = orderRepository.save(createdOrder);
            List<OrderQuantity> purchases = new ArrayList<>();
            albums.forEach((album -> {
                OrderQuantity orderQuantity = new OrderQuantity();
                OrderQuantityKey orderKey = new OrderQuantityKey();
                orderQuantity.setOrder(dbOrder);
                orderQuantity.setAlbum(album);
                Integer quantityRequest = newOrder.getAlbums().stream().filter(
                        item -> item.getAlbumId() == album.getAlbumId()
                ).toList().get(0).getQuantity();
                album.setStock(album.getStock() - quantityRequest);
                orderQuantity.setQuantity(quantityRequest);
                purchases.add(orderQuantity);
                UUID orderId = orderQuantity.getOrder().getOrderId();
                UUID albumId = orderQuantity.getAlbum().getAlbumId();
                orderKey.setOrderId(orderId);
                orderKey.setAlbumID(albumId);
                orderQuantity.setOrderKey(orderKey);
                orderQuantityRepository.save(orderQuantity);
            }));
            createdOrder.setPurchases(purchases);
            return createdOrder;
        }
        return createdOrder;
    }

}

