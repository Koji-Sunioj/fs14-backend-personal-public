package com.rest_api.fs14backend.order;

import com.rest_api.fs14backend.album.AlbumRepository;
import com.rest_api.fs14backend.artist.ArtistService;
import com.rest_api.fs14backend.order.Order;
import com.rest_api.fs14backend.order.OrderRepository;
import com.rest_api.fs14backend.order_bridge.OrderQuantity;
import com.rest_api.fs14backend.order_bridge.OrderQuantityKey;
import com.rest_api.fs14backend.order_bridge.OrderQuantityRepository;
import com.rest_api.fs14backend.user.User;
import com.rest_api.fs14backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

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

    public Order createOrder(OrderDTO newOrder)
    {
        User existingUser = userService.getUser(newOrder.userId());
        Order createdOrder = new Order();
        createdOrder.setUser(existingUser);
        Order dbOrder = orderRepository.save(createdOrder);
        newOrder.albums().forEach((temp) -> {
            OrderQuantity orderQuantity = new OrderQuantity();
            OrderQuantityKey orderKey = new OrderQuantityKey();
            orderQuantity.setOrder(dbOrder);
            orderQuantity.setAlbum(albumRepository.findById(temp.albumId()).orElse(null));
            orderQuantity.setQuantity(temp.quantity());
            UUID orderId = orderQuantity.getOrder().getOrderId();
            UUID albumId = orderQuantity.getAlbum().getAlbumId();
            orderKey.setOrderId(orderId);
            orderKey.setAlbumID(albumId);
            orderQuantity.setOrderKey(orderKey);
            orderQuantityRepository.save(orderQuantity);
        });
        return dbOrder;
    }
}
