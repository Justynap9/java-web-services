package com.example.usersmodule.resources;

import com.example.usersmodule.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

    @Query("SELECT distinct u FROM Users u join fetch u.regDetails where u.lastName = ?1")
    List<Users> findAllByLastName(String last_name);
}
