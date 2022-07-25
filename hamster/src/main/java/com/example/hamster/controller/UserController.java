package com.example.hamster.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    @ResponseBody
    public String GetUser(@PathVariable int id){
        return null;
    }

    @RequestMapping("testActive")
    @ResponseBody
    public String testActive() {

//        ActiveOld active = new ActiveOld(1,100,new Date(),"hcx");

//        userService.insertOne(active);

        return "OK";
    }

}
