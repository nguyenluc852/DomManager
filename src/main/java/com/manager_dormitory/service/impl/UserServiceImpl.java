package com.manager_dormitory.service.impl;


import org.springframework.stereotype.Service;

import com.manager_dormitory.config.UserPrincipal;
import com.manager_dormitory.entity.User;
import com.manager_dormitory.repository.UserRepository;
import com.manager_dormitory.service.UserService;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserPrincipal findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        UserPrincipal userPrincipal = new UserPrincipal();
        if (null != user) {
            Set<String> authorities = new HashSet<>();
            if (null != user.getRoles()) user.getRoles().forEach(r -> {
                authorities.add(r.getRoleKey());
                r.getPermissions().forEach(p -> authorities.add(p.getPermissionKey()));
            });

            userPrincipal.setUserId(user.getId());
            userPrincipal.setUsername(user.getEmail());
            userPrincipal.setPassword(user.getPassword());
            userPrincipal.setAuthorities(authorities);
        }
        return userPrincipal;
    }

}
