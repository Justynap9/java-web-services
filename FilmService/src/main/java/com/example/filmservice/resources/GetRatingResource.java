package com.example.filmservice.resources;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetRatingResource {

    private final RestTemplate restTemplate;

    @GetMapping("/show")
    public ResponseEntity <List> showRating() {
        return restTemplate.getForEntity("http://localhost:8084/ratings", List.class);
    }


    @GetMapping("/show/id/{id}")
    public Object getRatingByID(@PathVariable Long id){
        Object rating =  restTemplate.getForObject("http://localhost:8084/ratings/{id}", Object.class, id);
        return rating;
    }

    @GetMapping("/show/users/{id}/ratings")
    public Object getRatingsByUser(@PathVariable Long id){
        Object movie =  restTemplate.getForObject("http://localhost:8084/users/{id}/ratings", Object.class, id);
        return movie;
    }
}
