package com.adas.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import com.adas.app.dto.UserDto;
import com.adas.app.dto.UsersDto;
import com.adas.app.mapper.UserMapper;
import com.adas.app.model.User;
import com.adas.app.request.UserRequest;
import com.adas.app.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/users")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserRequest userRequest) {
        User user = userMapper.map(userRequest);
        user = userService.save(user);
        if (user == null) {
            return null;
        }
        return ResponseEntity.ok(userMapper.map(user));
    }
    
    @GetMapping("/users")
    public UsersDto findAll() {
        List<User> users = userService.findAll();
        List<UserDto> userDtos = userMapper.map(users);
        return new UsersDto(userDtos);
    }

    @GetMapping("/users/{id}")
    public UserDto findById(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            return null;
        }
        return userMapper.map(user);
    }  
    
    @DeleteMapping("/users/{id}")
    public UserDto deleteById(@PathVariable int id) {
        User user = userService.deleteById(id);
        if (user == null) {
            return null;
        }
        return userMapper.map(user);
    }

    @PutMapping("users/{id}")
    public UserDto update(@PathVariable int id, @RequestBody UserRequest userRequest) {
        User user = userMapper.map(id, userRequest);
        user = userService.update(user);
        if (user == null) {
            return null;
        }
        return userMapper.map(user);
    }
}
