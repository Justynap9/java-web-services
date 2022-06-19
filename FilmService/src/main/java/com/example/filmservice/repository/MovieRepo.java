package com.example.filmservice.repository;

import com.example.filmservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Query("SELECT distinct m FROM Movie m where m.title = ?1")
    List<Movie> findAllByTitle(String title);

    @Query(value = "SELECT G.NAME, M.TITLE FROM MOVIE M INNER JOIN MOVIE_GENRES MG ON M.ID = MG.MOVIE_ID " +
            "INNER JOIN GENRE G ON MG.GENRES_ID = G.ID WHERE G.NAME=:name",nativeQuery = true)
    List findMoviesbyGenre(@Param("name") String name);
}
