package com.example.filmservice.requests;

import com.example.filmservice.models.Rating;
import com.example.filmservice.models.RegistrationDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String login;
    private String birthDate;
}
