package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final BCryptPasswordEncoder encoder;

    public UserAccountServiceImpl(UserAccountRepository repository,
                                  BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public UserAccount register(UserAccount user) {

        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        user.setPasswordHash(encoder.encode(user.getPasswordHash()));
        return repository.save(user);
    }

    @Override
    public UserAccount authenticate(String email, String password) {

        UserAccount user = repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!encoder.matches(password, user.getPasswordHash())) {
            throw new BadRequestException("Invalid credentials");
        }

        return user;
    }
}
