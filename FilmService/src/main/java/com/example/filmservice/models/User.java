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


}
