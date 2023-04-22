package com.risk.Service.lmp;

import com.risk.Jpa.UserJpa;
import com.risk.Service.UserService;
import com.risk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmp implements UserService {
    @Autowired
    UserJpa userJpa;
    @Override
    public String getPasswordByName(String name) {
        return userJpa.getPasswdByName(name);
    }

    @Override
    public User getUserByName(String name) {
        return userJpa.getUserByName(name);
    }


}
