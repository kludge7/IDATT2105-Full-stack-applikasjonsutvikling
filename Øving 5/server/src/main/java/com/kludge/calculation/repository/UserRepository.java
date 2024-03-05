package com.kludge.calculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kludge.calculation.model.User;
import java.util.Optional;

/**
 * Repository interface for User entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their username.
     */
    Optional<User> findByUsername(String username);
}
