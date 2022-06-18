package com.example.usersmodule.resources;

import com.example.usersmodule.models.RegistrationDetails;
import com.example.usersmodule.models.Users;
import com.example.usersmodule.models.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/")
@RequiredArgsConstructor
public class UserResource {

    private final
    UserRepo userRepo;

    private final
    RegistrationRepo registrationRepo;

    private final
    RatingRepo ratingRepo;

    @GetMapping("/users")
    public ResponseEntity<List> getUsers(@RequestParam(value = "last_name", required = false) String last_name){
        if (last_name!= null) {
            return new ResponseEntity(userRepo.findAllByLastName(last_name), HttpStatus.OK);
        }
        return new ResponseEntity(userRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Long id) {
        Optional<Users> itemById = userRepo.findById(id);
        if (itemById.isPresent()) {
            return new ResponseEntity<>(itemById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody Users user) {
        userRepo.saveAndFlush(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
/*
    @GetMapping("/registration/details")
    public ResponseEntity<List> getRegDetails(@RequestParam(value = "id", required = false) long id){
        if (id != null) {
            return new ResponseEntity(registrationDetailsRepo.findAllById(id), HttpStatus.OK);
        }
        return new ResponseEntity(registrationDetailsRepo.findAll(), HttpStatus.OK);
    }*/

    @GetMapping("registration/{id}")
    public ResponseEntity<RegistrationDetails> getGenre(@PathVariable Long id) {
        Optional<RegistrationDetails> itemById = registrationRepo.findById(id);
        if (itemById.isPresent()) {
            return new ResponseEntity<>(itemById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @PostMapping("/registration")
    public ResponseEntity createRegistration(@RequestBody RegistrationDetails registration) {
        registrationRepo.saveAndFlush(registration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("registration/{id}")
    public ResponseEntity deleteRegistrationInfo(@PathVariable Long id) {
        registrationRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/ratings")
    public ResponseEntity<List> getRatings(){
        return new ResponseEntity(ratingRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("ratings/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable Long id) {
        Optional<Rating> itemById = ratingRepo.findById(id);
        if (itemById.isPresent()) {
            return new ResponseEntity<>(itemById.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("ratings")
    public ResponseEntity createRating(@RequestBody Rating rating){
        ratingRepo.saveAndFlush(rating);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("ratings/{id}")
    public ResponseEntity deleteRating(@PathVariable Long id) {
        ratingRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("users/{id}/ratings")
    public ResponseEntity<List> getUsersRatings(@PathVariable Long id) {
        Optional<Users> itemById = userRepo.findById(id);
        if (itemById.isPresent()) {
            return new ResponseEntity<List>(itemById.get().getRatings(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
