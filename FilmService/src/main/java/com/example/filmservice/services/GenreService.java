package com.example.filmservice.services;

import com.example.filmservice.models.Genre;
import com.example.filmservice.repository.GenreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepo genreRepo;

    public GenreService(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    public Iterable<Genre> saveGenres(List<Genre> genres){
        return genreRepo.saveAll(genres);
    }
}
