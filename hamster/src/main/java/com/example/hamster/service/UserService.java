package com.example.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hamster.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

//    public User findById(int id) {
//        return userMapper.findById(id);
//    }

}
