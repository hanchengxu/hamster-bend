package com.example.hamster.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hamster.controller.bean.GetActiveBean;
import com.example.hamster.entity.Active;
import com.example.hamster.mapper.ActiveMapper;

@Service
public class ActiveService {
    @Autowired
    ActiveMapper activeMapper;

    public void insertOne(Active active) {
        activeMapper.insertOne(active);
    }

    /**
     * if getActiveBean's time params is null, get max lapCount,
     * else get lapCount between two time
     */
    public Integer findLapCount(GetActiveBean getActiveBean) {


        int lapCount =0;

    	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date startTime= null;
		Date endTime = null;

		if(null !=getActiveBean.getStartDate() && null !=getActiveBean.getEndDate()) {
		    try {
	            startTime = dateformat.parse(getActiveBean.getStartDate());
	            endTime = dateformat.parse(getActiveBean.getEndDate());
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		    List<Active> activeList = activeMapper.selectLapCountByDate(getActiveBean.getHamsterId(), startTime, endTime);

	        int maxCount = activeList.get(0).getLap_count();
	        int mixCount = activeList.get(activeList.size()-1).getLap_count();

	        lapCount = maxCount - mixCount;

		}else {

		    Active active = activeMapper.selectMapLapCount(getActiveBean.getHamsterId());

		    lapCount = active.getLap_count();
		}

		return lapCount;
    }

}
