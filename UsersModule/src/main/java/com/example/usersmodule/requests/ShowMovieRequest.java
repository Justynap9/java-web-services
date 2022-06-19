package com.example.usersmodule.requests;

import com.example.usersmodule.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShowMovieRequest {
    private String title;
    private String description;
    private Integer released_year;
    private String director;
    private Integer runtime_min;
    private String country;
    private List<Genre> genres;
}
