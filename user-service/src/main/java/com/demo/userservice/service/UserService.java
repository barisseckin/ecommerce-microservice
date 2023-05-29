package com.demo.userservice.service;

import com.demo.userservice.client.NotificationServiceClient;
import com.demo.userservice.dto.UserDto;
import com.demo.userservice.dto.converter.Converter;
import com.demo.userservice.dto.request.CreateUserRequest;
import com.demo.userservice.dto.request.SendSimpleMailMessageRequest;
import com.demo.userservice.exception.GeneralException;
import com.demo.userservice.model.User;
import com.demo.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final Converter converter;
    private final NotificationServiceClient notificationServiceClient;

    public UserDto save(CreateUserRequest request) {
        User saved = converter.toEntity(request);
        userRepository.save(saved);
        sendActivateCode(saved.getMail(), "test", "demo");
        return converter.toDto(saved);
    }

    public void delete(String mail) {
        User fromDb = getByMail(mail);
        userRepository.deleteById(fromDb.getId());
    }

    public UserDto getUserByMail(String mail) {
        return userRepository.findUserByMail(mail)
                .stream()
                .findFirst()
                .map(converter::toDto)
                .orElseThrow(() -> new GeneralException("user not found, mail: " + mail, HttpStatus.NOT_FOUND));

    }

    private User getByMail(String mail) {
        return userRepository.findUserByMail(mail)
                .orElseThrow(() -> new GeneralException("user not found, mail: " + mail, HttpStatus.NOT_FOUND));
    }

    private void sendActivateCode(String to, String title, String body) {
        SendSimpleMailMessageRequest request = new SendSimpleMailMessageRequest(
                to,
                title,
                body
        );

        notificationServiceClient.sendSimpleMailMessage(request);
    }
}
