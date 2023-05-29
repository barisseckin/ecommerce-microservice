package com.demo.userservice.dto.request;

public record SendSimpleMailMessageRequest(
        String to,
        String content,
        String title
) {
}
