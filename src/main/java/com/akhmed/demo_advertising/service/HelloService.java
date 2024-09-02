package com.akhmed.demo_advertising.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HelloService {


    @Secured("ADMIN")
    public String getAdmin() {
        return "admin";
    }

    @Secured("USER")
    public String getUser() {
        return "user";
    }


}
