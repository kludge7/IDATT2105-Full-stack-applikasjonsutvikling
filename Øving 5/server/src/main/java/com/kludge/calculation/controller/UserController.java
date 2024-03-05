package com.kludge.calculation.controller;

import com.kludge.calculation.dto.UserDto;
import com.kludge.calculation.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for handling user-related requests.
 * Provides endpoints for user registration, login, and logout.
 */
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") 
public class UserController {
    private final UserService userService;

    /**
     * Class constructor.
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Authenticates a user based on the provided username and password.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        boolean authenticated = userService.authenticate(userDto.getUsername(), userDto.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Login successful for user: " + userDto.getUsername());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed for user: " + userDto.getUsername());
        }
    }

    /**
     * Logout the current user.
     */
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody UserDto userDto) {
        userService.logout(userDto.getUsername());
        return ResponseEntity.ok("Logout successful");
    }
}
