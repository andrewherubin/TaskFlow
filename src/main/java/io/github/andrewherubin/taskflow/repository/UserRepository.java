package io.github.andrewherubin.taskflow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.andrewherubin.taskflow.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByUsername(String username);
    
}
