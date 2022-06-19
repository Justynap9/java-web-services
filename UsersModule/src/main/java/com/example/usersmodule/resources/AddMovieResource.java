package com.example.usersmodule.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.example.usersmodule.requests.AddMovieRequest;
import com.example.usersmodule.models.Movie;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddMovieResource {

    private final RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest) {
        Movie movie = new Movie(addMovieRequest.getTitle(), addMovieRequest.getDescription(),
                addMovieRequest.getReleased_year(), addMovieRequest.getDirector(), addMovieRequest.getRuntime_min(),
                addMovieRequest.getCountry(), addMovieRequest.getGenres());
        restTemplate.postForEntity("http://localhost:8081/movies", movie, ResponseEntity.class);
        return new ResponseEntity(HttpStatus.OK);
    }
}
