package com.example.filmservice.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {

    private Long userId;
    private String firstName;
    private String lastName;
    private String login;
    private String birthDate;
    private Boolean active;
    private RegistrationDetails regDetails;
    private List<Rating> ratings;

    public User(String firstName, String lastName, String login, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.birthDate = birthDate;
    }
}
