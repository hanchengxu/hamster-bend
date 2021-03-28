package com.example.hamster.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public Integer findLapCount(int hamsterId, String startDate, String endDate) {
    	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date startTime= null;
		Date endTime = null;
		try {
			startTime = dateformat.parse(startDate);
			endTime	= dateformat.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

    	List<Active> activeList = activeMapper.selectLapCountByDate(hamsterId, startTime, endTime);
    	int maxCount = activeList.get(0).getLap_count();
    	int mixCount = activeList.get(activeList.size()-1).getLap_count();
    	int lapCount = maxCount - mixCount;
		return lapCount;
    }

}
