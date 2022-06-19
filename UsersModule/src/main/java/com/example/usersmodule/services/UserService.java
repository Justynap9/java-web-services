package com.example.usersmodule.services;

import com.example.usersmodule.models.User;
import com.example.usersmodule.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepository;

    public UserService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }
}
