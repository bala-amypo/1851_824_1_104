package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }

    public UserAccount getUserById(Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public UserAccount getUserByUsername(String username) {
        return userAccountRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
    }

    public UserAccount createUser(UserAccount user) {
        // You could add password hashing here if needed
        return userAccountRepository.save(user);
    }

    public UserAccount updateUser(Long id, UserAccount updatedUser) {
        UserAccount existing = getUserById(id);
        existing.setUsername(updatedUser.getUsername());
        existing.setEmail(updatedUser.getEmail());
        existing.setPassword(updatedUser.getPassword());
        return userAccountRepository.save(existing);
    }

    public void deleteUser(Long id) {
        UserAccount existing = getUserById(id);
        userAccountRepository.delete(existing);
    }

    public boolean authenticate(String username, String password) {
        Optional<UserAccount> userOpt = userAccountRepository.findByUsername(username);
        return userOpt.filter(user -> user.getPassword().equals(password)).isPresent();
    }
}
