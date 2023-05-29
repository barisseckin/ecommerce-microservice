package com.demo.notificationservice.request;

public record SendSimpleMailMessageRequest(
        String to,
        String content,
        String title
) {
}
