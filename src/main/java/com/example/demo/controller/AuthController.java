package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.UserAccount;
import com.example.demo.service.UserAccountService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAccountService userAccountService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserAccountService userAccountService,
                          JwtTokenProvider jwtTokenProvider) {
        this.userAccountService = userAccountService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserAccount user) {
        UserAccount savedUser = userAccountService.register(user);
        String token = jwtTokenProvider.generateToken(savedUser);
        return ResponseEntity.ok(new AuthResponse(
                savedUser.getEmail(),
                savedUser.getId(),
                savedUser.getRole(),
                token
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserAccount user) {
        UserAccount authenticatedUser = userAccountService.authenticate(
                user.getEmail(), user.getPasswordHash());
        String token = jwtTokenProvider.generateToken(authenticatedUser);
        return ResponseEntity.ok(new AuthResponse(
                authenticatedUser.getEmail(),
                authenticatedUser.getId(),
                authenticatedUser.getRole(),
                token
        ));
    }
}
