package com.example.filmservice.resources;

import com.example.filmservice.requests.ActivateUserRequest;
import com.example.filmservice.requests.DeactivateUserRequest;
import com.example.filmservice.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class UserStatusResource {

    private final RestTemplate restTemplate;


    @PostMapping("/activate")
    public ResponseEntity activateUser(@RequestBody ActivateUserRequest activateuserRequest) {
        ResponseEntity<User[]> forEntity = restTemplate.getForEntity("http://localhost:8084/users", User[].class);
        for (User user: forEntity.getBody()) {
            if (user.getFirstName().equals(activateuserRequest.getFirstName()) && user.getLastName().equals(activateuserRequest.getLastName())) {
                user.setActive(true);
                restTemplate.postForEntity("http://localhost:8084/users", user, ResponseEntity.class);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/deactivate")
    public ResponseEntity deactivateUser(@RequestBody DeactivateUserRequest deactivateuserRequest) {
        ResponseEntity<User[]> forEntity = restTemplate.getForEntity("http://localhost:8084/users", User[].class);
        for (User user: forEntity.getBody()) {
            if (user.getFirstName().equals(deactivateuserRequest.getFirstName()) && user.getLastName().equals(deactivateuserRequest.getLastName())) {
                user.setActive(false);
                restTemplate.postForEntity("http://localhost:8084/users", user, ResponseEntity.class);
            }
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}