package com.sanjeev.studentmanagement.controller;

import com.sanjeev.studentmanagement.dto.LoginRequest;
import com.sanjeev.studentmanagement.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.sanjeev.studentmanagement.dto.LoginResponse;
import com.sanjeev.studentmanagement.dto.RegisterRequest;
import com.sanjeev.studentmanagement.model.User;
import com.sanjeev.studentmanagement.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
private UserService userService;

 @PostMapping("/login")
public LoginResponse login(@RequestBody LoginRequest loginRequest) {

    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(),
                    loginRequest.getPassword()
            )
    );

    String token = jwtService.generateToken(loginRequest.getUsername());

    return new LoginResponse(token);
}
@PostMapping("/register")
public String register(@RequestBody RegisterRequest registerRequest) {

    User user = new User();

    user.setUsername(registerRequest.getUsername());
  user.setPassword(registerRequest.getPassword());
    user.setRole(registerRequest.getRole());

    userService.saveUser(user);

    return "User Registered Successfully";
}
}