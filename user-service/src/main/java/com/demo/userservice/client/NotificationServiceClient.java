package com.demo.userservice.client;

import com.demo.userservice.dto.request.SendSimpleMailMessageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", path = "/v1/api/notification")
public interface NotificationServiceClient {

    @PostMapping
    ResponseEntity<Void> sendSimpleMailMessage(@RequestBody SendSimpleMailMessageRequest request);
}
