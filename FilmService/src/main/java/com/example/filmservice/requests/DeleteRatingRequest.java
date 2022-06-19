package com.example.filmservice.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRatingRequest {
    private Long userId;
    private Long movieId;
    private Integer score;
    private String review;
}
