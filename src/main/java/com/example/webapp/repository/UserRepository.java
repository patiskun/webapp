package com.example.webapp.repository;

import com.example.webapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM usr u WHERE u.email = ?1")
    User findByEmail(String email);
}