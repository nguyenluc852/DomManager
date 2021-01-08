package com.manager_dormitory.service;

import com.manager_dormitory.entity.Token;

public interface TokenService {
	Token createToken(Token token);
	
	Token findByToken(String token);
}
