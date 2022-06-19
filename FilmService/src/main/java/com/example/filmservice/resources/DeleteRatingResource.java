package com.example.filmservice.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class DeleteRatingResource {

    private final RestTemplate restTemplate;

    @DeleteMapping("/delete-rating/{id}")
    public ResponseEntity deleteRating(@PathVariable Long id) {
        restTemplate.delete("http://localhost:8084/ratings/{id}", id);
        return new ResponseEntity(HttpStatus.OK);

    }
}
