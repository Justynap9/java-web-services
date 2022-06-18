package com.example.filmservice.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private Long ratingId;
    private Long userId;
    private Long movieId;
    private Integer score;
    private String review;
    private String status;

    public Rating(Long userId, Long movieId, Integer score, String review) {
        this.userId = userId;
        this.movieId = movieId;
        this.score = score;
        this.review = review;
        this.status = "created";
    }
}
