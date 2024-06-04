package com.example.loginapplication;

import com.example.loginapplication.model.User;
import com.example.loginapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/*
Initialises the user and manager accounts for login
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User("John Doe", "johndoe", passwordEncoder.encode("password"), "user"));
        userRepository.save(new User("Jane Doe", "janedoe", passwordEncoder.encode("password"), "manager"));
    }
}
