package com.sanjeev.studentmanagement.service;

import com.sanjeev.studentmanagement.model.User;
import com.sanjeev.studentmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set default role if none is provided
        if (user.getRole() == null || user.getRole().isBlank()) {
            user.setRole("USER");
        }

        return userRepository.save(user);
    }
}