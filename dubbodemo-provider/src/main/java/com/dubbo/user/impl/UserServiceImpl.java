package com.dubbo.user.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.UserService;
import com.dubbo.dao.user.UserMapper;
import com.dubbo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserServiceImpl  implements UserService{
    public String sayHi(String s) {
        return "hello " + s + "!";
    }

    @Autowired
    private UserMapper userMapper;
    public User select(){
        userMapper.deleteByPrimaryKey(2);
        User user1 = new User() ;
        user1.setAge(1);
        user1.setId(2);
        user1.setName("123123");
        user1.setTel("184572170255");
        userMapper.insert(user1);
        user1.setName("ceswhi");
        userMapper.updateByPrimaryKey(user1);
        User user =userMapper.selectByPrimaryKey(9);
        System.out.println(user);
        return  user;
    }

}
