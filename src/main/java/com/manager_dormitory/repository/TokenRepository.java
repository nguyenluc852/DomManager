package com.manager_dormitory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager_dormitory.entity.Token;

public interface  TokenRepository extends JpaRepository<Token, Long> {
	
	Token findByToken(String token);
}
