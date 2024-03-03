package com.kludge.calculator.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CalculatorController {

    private String loggedInUser = null;

    @PostMapping("/login")
    public String login(@RequestBody UserCredentials credentials) {
        if (loggedInUser == null) {
            if (credentials.getUsername().equals("user") && credentials.getPassword().equals("password")) {
                loggedInUser = credentials.getUsername();
                return "Login successful";
            } else {
                return "Invalid username and/or password";
            }
        } else {
            return "Someone is already logged in";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        if (loggedInUser != null) {
            String user = loggedInUser;
            loggedInUser = null;
            return "Logout successful for user: " + user;
        } else {
            return "No user is currently logged in";
        }
    }

    static class UserCredentials {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}
