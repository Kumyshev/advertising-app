package com.akhmed.demo_advertising.controller;

import org.springframework.web.bind.annotation.RestController;

import com.akhmed.demo_advertising.model.User;
import com.akhmed.demo_advertising.service.HelloService;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping(value = "magazines")
@RequiredArgsConstructor
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    private final HelloService service;

    @GetMapping("/admin")
    public String getAdmin() {
        String name = "Akhmed";
        logger.debug("Debug level - Hello Logback {}", name);
        return "hello " + service.getAdmin() + "!";
    }

    @GetMapping("/user")
    public String getUser() {
        return "hello " + service.getUser() + "!";
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String name) {
        return null;
    }

}
