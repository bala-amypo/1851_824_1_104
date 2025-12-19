package com.example.demo.service;

import com.example.demo.model.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {
    private final UserAccountRepository repository;

    public UserAccountService(UserAccountRepository repository) {
        this.repository = repository;
    }

    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserAccount> getUserById(Long id) {
        return repository.findById(id);
    }

    public UserAccount createUser(UserAccount user) {
        return repository.save(user);
    }

    public UserAccount updateUser(UserAccount user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}

