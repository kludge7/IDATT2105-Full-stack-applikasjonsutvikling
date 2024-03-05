package com.kludge.calculation.services;

import com.kludge.calculation.model.User;
import com.kludge.calculation.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByUsernameShouldReturnNullIfNotFound() {
        String username = "nonExistentUser";
        when(userRepository.findByUsername("nonexistentUser")).thenReturn(Optional.empty());

        User foundUser = userService.findByUsername(username);

        assertNull(foundUser);
    }
}
