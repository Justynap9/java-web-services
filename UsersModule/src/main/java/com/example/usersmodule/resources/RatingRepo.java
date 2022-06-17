package com.example.usersmodule.resources;

import com.example.usersmodule.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {
    @Query("SELECT distinct r FROM Rating r join fetch r.userId where r.review= ?1")
    List<Rating> findAllByReview(String review);
}
