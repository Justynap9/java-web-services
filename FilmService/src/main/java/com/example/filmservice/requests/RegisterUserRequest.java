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
    private Long userId;
    private String firstName;
    private String lastName;
    private String login;
    private String birthDate;
    private Boolean active;
    private RegistrationDetails regDetails;
    private List<Rating> ratings;
}
