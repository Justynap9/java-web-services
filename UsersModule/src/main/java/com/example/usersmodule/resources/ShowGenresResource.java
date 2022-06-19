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
public class ShowGenresResource {

    private final RestTemplate restTemplate;

    @GetMapping("/show-genres")
    public ResponseEntity<List> showGenres() {
        return restTemplate.getForEntity("http://localhost:8081/genres", List.class);
    }

    @GetMapping("/show-genres/id/{id}")
    public Object getGenres(@PathVariable Long id){
        Object genre =  restTemplate.getForObject("http://localhost:8081/genres/id/{id}", Object.class, id);
        return genre;
    }

    @GetMapping("/show-genres/{name}")
    public Object getMovies(@PathVariable String name){
        Object genre =  restTemplate.getForObject("http://localhost:8081/genres?name={name}", Object.class, name);
        return genre;
    }
}
