package com.example.spa_week04_test.repository;

import com.example.spa_week04_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String usename);
}
