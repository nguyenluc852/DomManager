package com.manager_dormitory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager_dormitory.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    
    User findById(int id);
    
    User findByEmail(String username);
}