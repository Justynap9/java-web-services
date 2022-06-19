package com.example.filmservice.services;

import com.example.filmservice.models.Movie;
import com.example.filmservice.resources.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movieRepository;

    public MovieService(MovieRepo movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> saveMovies(List<Movie> movies) {
        return movieRepository.saveAll(movies);
    }
}
