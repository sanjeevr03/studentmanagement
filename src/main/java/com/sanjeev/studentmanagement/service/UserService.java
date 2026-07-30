package com.sanjeev.studentmanagement.service;

import com.sanjeev.studentmanagement.model.User;
import com.sanjeev.studentmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {

    user.setPassword(
            passwordEncoder.encode(user.getPassword())
    );

    return userRepository.save(user);
}
    }
