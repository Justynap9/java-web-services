package com.example.filmservice.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String login;
    private String birthDate;
    private LocalDateTime regDate = LocalDateTime.now();
}
