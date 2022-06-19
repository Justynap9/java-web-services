package com.example.filmservice.resources;

import com.example.filmservice.models.User;
import com.example.filmservice.requests.RegisterUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class RegisterUserResource {

    private final RestTemplate restTemplate;

    @PostMapping("/register-user")
    public ResponseEntity createUser(@RequestBody RegisterUserRequest registeruserRequest) {
        User user = new User(registeruserRequest.getFirstName(),
                registeruserRequest.getLastName(), registeruserRequest.getLogin(),
                registeruserRequest.getBirthDate(), registeruserRequest.getRegDate());
        restTemplate.postForEntity("http://localhost:8084/users", user, ResponseEntity.class);
        return new ResponseEntity(HttpStatus.OK);

    }
}
