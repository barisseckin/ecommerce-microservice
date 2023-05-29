package com.demo.userservice.dto.converter;

import com.demo.userservice.dto.UserDto;
import com.demo.userservice.dto.request.CreateUserRequest;
import com.demo.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class Converter {

    public UserDto toDto(User from) {
        return new UserDto(
                from.getUsername(),
                from.getMail(),
                from.isNotificationEnabled(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public User toEntity(CreateUserRequest from) {
        return new User(
                from.username(),
                from.mail(),
                from.password()
        );
    }
}
