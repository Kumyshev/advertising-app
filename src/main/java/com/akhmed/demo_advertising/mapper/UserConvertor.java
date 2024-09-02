package com.akhmed.demo_advertising.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.akhmed.demo_advertising.dto.UserDto;
import com.akhmed.demo_advertising.model.User;

@Component
public class UserConvertor {
    private final ModelMapper modelMapper;

    public UserConvertor() {
        this.modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true).setSkipNullEnabled(true);
    }

    public UserDto toUserDto(User user) {
        if (!user.getComments().isEmpty() && user.getComments() != null)
            modelMapper.createTypeMap(User.class, UserDto.class)
                    .addMappings(mapper -> {
                        mapper.map(src -> src.getComments()
                                .stream().map(u -> u.getId()), UserDto::setComments);
                    });

        return modelMapper.map(user, UserDto.class);
    }
}
