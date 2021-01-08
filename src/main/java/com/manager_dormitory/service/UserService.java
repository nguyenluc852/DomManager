package com.manager_dormitory.service;

import java.util.Optional;

import com.manager_dormitory.config.UserPrincipal;
import com.manager_dormitory.entity.User;

public interface UserService {
	
	User createUser(User user);
	UserPrincipal findByEmail(String email);
}
