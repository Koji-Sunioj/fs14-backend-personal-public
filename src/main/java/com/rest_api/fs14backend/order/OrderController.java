package com.rest_api.fs14backend.order;


import com.rest_api.fs14backend.order.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public HashMap<String,Object> getAllOrders()
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        List<Order> orders = orderService.getOrders();
        response.put("orders",orders);
        return response;
    }

    @GetMapping("{orderId}")
    public HashMap<String,Object> getOrder(@PathVariable UUID orderId)
    {
        HashMap<String,Object> response = new HashMap<String,Object>();
        Order order = orderService.getOrder(orderId);
        response.put("order",order);
        return response;
    }

    @PostMapping(value="/",consumes = {"application/json"})
    public HashMap<String,Object> createOrder(@RequestBody OrderDTO requestOrder)
    {
        Order createdOrder = orderService.createOrder(requestOrder);
        HashMap<String,Object> response = new HashMap<String,Object>();
        response.put("message",String.format("successfull created order %s",createdOrder.getOrderId()));
        response.put("order",createdOrder);
        return response;
    }
}
