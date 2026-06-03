package com.example.notification_server.kafka;

import com.example.notification_server.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(
            topics = "order-topic",
            groupId = "order-group"
    )
    public void consume(OrderEvent event) {
        System.out.println("Received Order Event:");
        System.out.println("Order ID: " + event.getOrderId());
        System.out.println("Status: " + event.getStatus());
    }
}