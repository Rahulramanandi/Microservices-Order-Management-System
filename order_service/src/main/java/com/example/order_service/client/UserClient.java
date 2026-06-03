package com.example.order_service.client;

import com.example.order_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/api/users/{id}")
    UserDto getUserById(@PathVariable Long id);

    @PostMapping("/api/users")
    UserDto createUser(@RequestBody UserDto userDto);
}