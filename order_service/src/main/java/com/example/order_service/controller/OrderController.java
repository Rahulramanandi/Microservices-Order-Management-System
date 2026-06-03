package com.example.order_service.controller;

import com.example.order_service.dto.OrderResponse;
import com.example.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}/user/{userId}")
    public OrderResponse getOrderWithUserId(
            @PathVariable Long orderId,
            @PathVariable Long userId
    ) {
        return orderService.getOrderWithUser(orderId, userId);
    }
}