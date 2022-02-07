package com.examly.springapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.models.user;

import java.util.Optional;

public interface UserRepository extends JpaRepository<user, Integer> {
    Optional<user> findByEmail(String email);
}

