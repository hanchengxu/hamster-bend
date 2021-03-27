package com.example.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hamster.entity.Active;
import com.example.hamster.entity.User;
import com.example.hamster.mapper.ActiveMapper;
import com.example.hamster.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ActiveMapper activeMapper;

    public User findById(int id) {
        return userMapper.findById(id);
    }

    public void insertOne(Active active) {
        activeMapper.insertOne(active);
    }

}
