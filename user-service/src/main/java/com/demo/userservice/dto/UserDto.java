package com.demo.userservice.dto;

import java.time.LocalDateTime;

public record UserDto(
        String username,
        String mail,
        boolean notificationEnabled,
        LocalDateTime createDate,
        LocalDateTime updateDate
) {
}
