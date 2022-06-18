package com.example.usersmodule.resources;

import com.example.usersmodule.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("SELECT distinct u FROM User u join fetch u.regDetails where u.lastName = ?1")
    List<User> findAllByLastName(String last_name);
}
