package com.example.usersmodule.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Long Id;
    private String title;
    private String description;
    private Integer released_year;
    private String director;
    private Integer runtime_min;
    private String country;
    private List<Genre> genres;

    public Movie(String title, String description, Integer released_year, String director, Integer runtime_min,
                 String country, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.released_year = released_year;
        this.director = director;
        this.runtime_min = runtime_min;
        this.country = country;
        this.genres = genres;
    }
}
