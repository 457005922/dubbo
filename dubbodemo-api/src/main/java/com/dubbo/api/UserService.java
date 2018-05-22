package com.dubbo.api;

import com.dubbo.entity.User;

public interface UserService {
    String sayHi(String name);
    User  select();
}
