package com.akhmed.demo_advertising.controller;

import org.springframework.web.bind.annotation.RestController;

import com.akhmed.demo_advertising.dto.UserDto;
import com.akhmed.demo_advertising.impl.IUserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public UserDto saveUser(@Valid @RequestBody UserDto dto) {
        return userService.saveUser(dto);
    }
}
