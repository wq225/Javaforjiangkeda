package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.User;

public interface UserService {
    User checkUser(String username, String password);
}
