package com.manager_dormitory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager_dormitory.entity.Token;
import com.manager_dormitory.repository.TokenRepository;
import com.manager_dormitory.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token){
        return tokenRepository.saveAndFlush(token);
    }

	@Override
	public Token findByToken(String token) {
		
		return tokenRepository.findByToken(token);
	}
    
    
}
