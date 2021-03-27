package com.example.hamster.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.controller.bean.SaveActiveBean;
import com.example.hamster.entity.Active;
import com.example.hamster.service.ActiveService;

@RestController
public class ActiveController {

    @Autowired
    ActiveService activeService;

    /**
     * save lap_count from mqtt
     */
    @RequestMapping("saveActive")
    public String saveActive(@RequestBody SaveActiveBean activeBean) {

        System.out.println(activeBean);

        Active active = new Active(activeBean.getMsg().get(0),activeBean.getMsg().get(1),new Date(),"system");

        activeService.insertOne(active);

        return "OK";
    }
}
