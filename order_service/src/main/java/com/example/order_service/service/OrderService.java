package com.example.order_service.service;


import com.example.order_service.client.UserClient;
import com.example.order_service.dto.OrderEvent;
import com.example.order_service.dto.OrderResponse;
import com.example.order_service.dto.UserDto;
import com.example.order_service.kafka.OrderProducer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final UserClient userClient;
    private final OrderProducer orderProducer;

    public OrderService(UserClient userClient,OrderProducer orderProducer) {

        this.userClient = userClient;
        this.orderProducer = orderProducer;
    }

    @CircuitBreaker(name = "userServiceBreaker", fallbackMethod = "userFallback")
    public OrderResponse getOrderWithUser(Long orderId, Long userId) {

        UserDto user = userClient.getUserById(userId);

        OrderEvent event = new OrderEvent(
                orderId,
                "ORDER_CREATED"
        );

        orderProducer.sendOrderEvent(event);

        return new OrderResponse(
                orderId,
                "Laptop",
                user
        );
    }

    public OrderResponse userFallback(Long orderId,Long userId, Exception ex) {

        UserDto fallbackUser = new UserDto();
        fallbackUser.setId(0L);
        fallbackUser.setName("User Service Temporarily Unavailable");
        fallbackUser.setEmail("fallback@example.com");

        return new OrderResponse(orderId, "Laptop", fallbackUser);
    }
}
