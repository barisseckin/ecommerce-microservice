package com.demo.notificationservice.controller;

import com.demo.notificationservice.request.SendSimpleMailMessageRequest;
import com.demo.notificationservice.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> sendSimpleMailMessage(@RequestBody SendSimpleMailMessageRequest request) {
        notificationService.sendSimpleMailMessage(request);
        return ResponseEntity.noContent().build();
    }
}
