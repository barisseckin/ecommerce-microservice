package com.demo.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "notification-service", path = "/v1/api/notification")
public interface NotificationServiceClient {
}
