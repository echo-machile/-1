package com.risk.Service;

import com.risk.entity.User;

public interface UserService {


    String getPasswordByName(String name);

    User getUserByName(String name);
}
