package com.akhmed.demo_advertising.impl;

import java.util.List;

import com.akhmed.demo_advertising.dto.UserDto;

public interface IUserService {

    public UserDto saveUser(UserDto userDto);

    public List<UserDto> findAll();

    public List<UserDto> findByName(String name);
}
