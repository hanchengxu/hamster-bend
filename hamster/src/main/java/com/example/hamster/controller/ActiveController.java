package com.example.hamster.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.controller.bean.GetActiveBean;
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

        Active active = new Active(activeBean.getMsg().get(0),activeBean.getMsg().get(1),new Date(),"system");

        activeService.insertOne(active);

        return "OK";
    }

    @RequestMapping(value= "getLapCount",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String getlapCount(@RequestBody GetActiveBean getActiveBean) {

        Integer lapCount = activeService.findLapCount(getActiveBean);

        return "{\"lapCount\":"+lapCount+"}";
    }

    @RequestMapping(value= "getMaxLapCount",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getMaxLapCount(@RequestParam(name = "hamsterId", required = true) Integer hamsterId) {

        if(null == hamsterId) {
            return null;
        }

        GetActiveBean bean = new GetActiveBean();
        bean.setHamsterId(hamsterId);

        Integer lapCount = activeService.findLapCount(bean);

        return "{\"lapCount\":"+lapCount+"}";
    }

}
