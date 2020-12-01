package com.neusoft.springbootsell.services.impl;

import com.neusoft.springbootsell.dataobject.User;
import com.neusoft.springbootsell.repository.UserRepository;
import com.neusoft.springbootsell.services.UserService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User checkUser(String username, String password) {
        return repository.findByUsernameAndPassword(username,password);
    }
}