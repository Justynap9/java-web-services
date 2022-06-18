package com.example.filmservice.resources;

import com.example.filmservice.models.Genre;
import com.example.filmservice.models.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/")
@RequiredArgsConstructor
public class CatalogResource {

    private final MovieRepo movieRepo;
    private final GenreRepo genreRepo;

    @GetMapping("/movies")
    public ResponseEntity<List> getMovies(@RequestParam(value = "title", required = false) String title){
        if (title != null) {
            return new ResponseEntity(movieRepo.findAllByTitle(title), HttpStatus.OK);
        }
        return new ResponseEntity(movieRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("movie/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Optional<Movie> itemById = movieRepo.findById(id);
        if (itemById.isPresent()) {
            return new ResponseEntity<>(itemById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @PostMapping("/movies")
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        movieRepo.saveAndFlush(movie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("movies/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id) {
        movieRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/genres")
    public ResponseEntity<List> getGenres(@RequestParam(value = "name", required = false) String name){
        if (name != null) {
            return new ResponseEntity(genreRepo.findAllByName(name), HttpStatus.OK);
        }
        return new ResponseEntity(genreRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("genre/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long id) {
        Optional<Genre> itemById = genreRepo.findById(id);
        if (itemById.isPresent()) {
            return new ResponseEntity<>(itemById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @PostMapping("/genres")
    public ResponseEntity createGenre(@RequestBody Genre genre) {
        genreRepo.saveAndFlush(genre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("genres/{id}")
    public ResponseEntity deleteGenres(@PathVariable Long id) {
        genreRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
