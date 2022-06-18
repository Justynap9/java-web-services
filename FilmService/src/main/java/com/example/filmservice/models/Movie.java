package com.example.filmservice.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Movie")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String description;
    private Integer released_year;
    private String director;
    private Integer runtime_min;
    private String country;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id")
    private List<Genre> genres;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleased_year() {
        return released_year;
    }

    public void setReleased_year(Integer released_year) {
        this.released_year = released_year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getRuntime_min() {
        return runtime_min;
    }

    public void setRuntime_min(Integer runtime_min) {
        this.runtime_min = runtime_min;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
