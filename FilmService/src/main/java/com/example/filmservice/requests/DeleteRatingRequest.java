package com.example.filmservice.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteRatingRequest {

    private Long ratingid;
    private Long userId;
    private String status = "Deleted";

}
