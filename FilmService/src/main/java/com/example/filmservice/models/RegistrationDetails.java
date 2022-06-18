package com.example.filmservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationDetails {

    private Long regId;
    private LocalDateTime regDate = LocalDateTime.now();

    public RegistrationDetails(Long regId) {
        this.regId = regId;
    }
}
