package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Query("SELECT distinct m FROM Movie m join fetch m.genres where m.title = ?1")
    List<Movie> findAllByTitle(String title);
}
