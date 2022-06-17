package com.example.usersmodule.resources;

import com.example.usersmodule.models.RegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationDetails, Long> {

    @Query("SELECT distinct rd FROM RegistrationDetails rd where rd.regId= ?1")
    List<RegistrationDetails> findAllById(Long Id);
}
