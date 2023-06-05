package com.demo.userservice.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @Email
        String mail
) {
}
