package com.example.filmservice.repository;

import com.example.filmservice.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {

    @Query("SELECT distinct g FROM Genre g where g.name= ?1")
    List<Genre> findAllByName(String name);
}
