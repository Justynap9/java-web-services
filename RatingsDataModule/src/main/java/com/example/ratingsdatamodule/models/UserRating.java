package com.example.ratingsdatamodule.models;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Table;
import java.util.List;

@Table(name = "UserRating")
@ToString
@NoArgsConstructor

public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
