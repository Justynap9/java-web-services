package com.example.filmservice.resources;

import com.example.filmservice.models.Rating;
import com.example.filmservice.requests.CreateRatingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CreateRatingResource {

    private final RestTemplate restTemplate;

    @PostMapping("/user-ratings/create")
    public ResponseEntity createRating(@RequestBody CreateRatingRequest createratingRequest) {
        Rating rating = new Rating(createratingRequest.getUserId(), createratingRequest.getMovieId(), createratingRequest.getScore(),
                createratingRequest.getReview(), "created");
        restTemplate.postForEntity("http://localhost:8084/users/{id}/ratings", rating, ResponseEntity.class, createratingRequest.getUserId());
        return new ResponseEntity(HttpStatus.OK);

    }
}
