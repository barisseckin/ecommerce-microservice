package com.demo.userservice.controller;

import com.demo.userservice.dto.UserDto;
import com.demo.userservice.dto.request.CreateUserRequest;
import com.demo.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody @Valid CreateUserRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(request));
    }

    @GetMapping
    public ResponseEntity<UserDto> getUserByMail(@RequestParam String mail) {
        return ResponseEntity.ok(userService.getUserByMail(mail));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String mail) {
        userService.delete(mail);
        return ResponseEntity.noContent().build();
    }
}
