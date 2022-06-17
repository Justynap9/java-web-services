package com.example.usersmodule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String login;
    private String birthDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regId")
    private RegistrationDetails regDetails;
}
