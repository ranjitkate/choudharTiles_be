package com.example.choudharTiles.repository;

import com.example.choudharTiles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed
    User findByEmail(String email);
}