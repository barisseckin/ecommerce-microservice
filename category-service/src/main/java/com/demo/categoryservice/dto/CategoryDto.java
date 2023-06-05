package com.demo.categoryservice.dto;

import java.time.LocalDateTime;

public record CategoryDto(
        String name,
        String uuid,
        LocalDateTime createDate,
        LocalDateTime updateDate
) {
}
