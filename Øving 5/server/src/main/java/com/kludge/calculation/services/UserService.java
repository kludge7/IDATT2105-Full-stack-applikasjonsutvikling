package com.kludge.calculation.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kludge.calculation.model.User;
import com.kludge.calculation.repository.UserRepository;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service class for managing users.
 * Provides functionality for user registration, deletion, and authentication.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    // Keeping track of who is already logged in
    private final Set<String> activeSessions = Collections.newSetFromMap(new ConcurrentHashMap<>());

    /**
     * Class constructor.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Find a User by their username.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    /**
     * Find a User by their ID.
     */
    @SuppressWarnings("null")
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Authenticate a user. Check if the provided username and password
     * matches any that is present in the DB and if the user is not already logged in.
     */
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null && !activeSessions.contains(username)) {
            boolean authenticated = user.getPassword().equals(password);
            if (authenticated) {
                activeSessions.add(username); 
            } 
            return authenticated;
        } else {
            return false;
        }
    }

    /**
     * Logs out the user and removes them from the active sessions.
     */
    public void logout(String username) {
        activeSessions.remove(username);
    }
}
