package com.example.loginapplication.controller;

import com.example.loginapplication.model.User;
import com.example.loginapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        User user = userService.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user == null) {
            System.out.println("Login failed for user: " + loginRequest.getUsername());
            return ResponseEntity.status(401).body("Invalid userid or password");
        }
        System.out.println("Login successful for user: " + user.getUsername());
        return ResponseEntity.ok(user);
    }
}