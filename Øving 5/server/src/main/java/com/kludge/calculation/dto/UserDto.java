package com.kludge.calculation.dto;

/**
 * Data Transfer Object for carrying user data between processes.
 * It encapsulates user details including username and password, primarily used for registration and authentication.
 */
public class UserDto {
    private Long id;
    private String username;
    private String password;

    // Standard getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
