package com.example.usersmodule.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "RegistrationDetails")
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regId;
    @OneToOne
    @JoinColumn(name ="userId")
    private User userId;
    private LocalDateTime regDate = LocalDateTime.now();

    public RegistrationDetails(User userId) {
        this.userId = userId;
        this.regDate = LocalDateTime.now();
    }
}
