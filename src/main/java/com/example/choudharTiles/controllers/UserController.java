package com.example.choudharTiles.controllers;

import com.example.choudharTiles.entity.User;
import com.example.choudharTiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginUser) {
        User existingUser = userRepository.findByEmail(loginUser.getEmail());
        if (existingUser != null &&
                existingUser.getPassword().equals(loginUser.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }

    // 👉 Keep this last
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}
