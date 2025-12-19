package com.example.demo.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        // TEMPORARY IN-MEMORY USER
        // Replace later with DB logic

        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username("admin")
                .password("{noop}admin123") // no encoding (TEMP)
                .roles("USER")
                .build();
    }
}
