package com.example.usersmodule.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShowMoviesResource {

    private final RestTemplate restTemplate;

    @GetMapping("/show")
    public ResponseEntity <List> showMovies() {
        return restTemplate.getForEntity("http://localhost:8081/movies", List.class);
    }

    @GetMapping("/show/id/{id}")
    public Object getMovies(@PathVariable Long id){
        Object movie =  restTemplate.getForObject("http://localhost:8081/movies/id/{id}", Object.class, id);
        return movie;
    }

    @GetMapping("/show/title/{title}")
    public Object getMovies(@PathVariable String title){
        Object movie =  restTemplate.getForObject("http://localhost:8081/movies/title/{title}", Object.class, title);
        return movie;
    }
}
