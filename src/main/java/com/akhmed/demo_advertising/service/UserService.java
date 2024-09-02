package com.akhmed.demo_advertising.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.akhmed.demo_advertising.dto.UserDto;
import com.akhmed.demo_advertising.impl.IUserService;
import com.akhmed.demo_advertising.mapper.UserConvertor;
import com.akhmed.demo_advertising.model.User;
import com.akhmed.demo_advertising.repository.UserRepository;
import com.akhmed.demo_advertising.repository.UserSpecifications;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    private final UserConvertor userConvertor;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .creationDate(LocalDateTime.now())
                .build();
        return userConvertor.toUserDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userConvertor::toUserDto).toList();
    }

    @Override
    public List<UserDto> findByName(String name) {
        final Specification<User> specification = UserSpecifications.hasName(name);
        return userRepository.findByName(specification).stream().map(userConvertor::toUserDto).toList();
    }

}
