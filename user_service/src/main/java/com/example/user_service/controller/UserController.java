package com.example.user_service.controller;

import com.example.user_service.Exception.ResourceNotFoundException;
import com.example.user_service.userDto.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        if(id<=0) throw new ResourceNotFoundException("User Not Found With id "+id);
        return new UserDto(id, "Rahul from port "+serverPort, "rahul@example.com");
    }
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        System.out.println("User created: " + userDto);
        return userDto;
    }
}
