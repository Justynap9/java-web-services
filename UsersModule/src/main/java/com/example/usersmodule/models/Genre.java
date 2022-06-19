package com.example.usersmodule.models;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    private Long Id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
