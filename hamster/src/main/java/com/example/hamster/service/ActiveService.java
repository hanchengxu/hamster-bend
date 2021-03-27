package com.example.hamster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hamster.entity.Active;
import com.example.hamster.mapper.ActiveMapper;

@Service
public class ActiveService {
    @Autowired
    ActiveMapper activeMapper;

    public void insertOne(Active active) {
        activeMapper.insertOne(active);
    }
}
