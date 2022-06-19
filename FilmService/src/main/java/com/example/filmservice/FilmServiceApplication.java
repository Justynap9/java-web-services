package com.example.filmservice;

import com.example.filmservice.models.Genre;
import com.example.filmservice.models.Movie;
import com.example.filmservice.services.GenreService;
import com.example.filmservice.services.MovieService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class FilmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MovieService movieService, GenreService genreService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Movie>> typeReferenceM = new TypeReference<>(){};
            TypeReference<List<Genre>> typeReferenceG = new TypeReference<>(){};
            InputStream inputStreamM = TypeReference.class.getResourceAsStream("/json/Movies.json");
            InputStream inputStreamG = TypeReference.class.getResourceAsStream("/json/Genres.json");
            try {
                List<Genre> genres = mapper.readValue(inputStreamG,typeReferenceG);
                genreService.saveGenres(genres);
                System.out.println("Genres Saved!");
            } catch (IOException e){
                System.out.println("Unable to save genres: " + e.getMessage());
            }
            try {
                List<Movie> movies = mapper.readValue(inputStreamM,typeReferenceM);
                movieService.saveMovies(movies);
                System.out.println("Movies Saved!");
            } catch (IOException e){
                System.out.println("Unable to save movies: " + e.getMessage());
            }

        };
    }
}
