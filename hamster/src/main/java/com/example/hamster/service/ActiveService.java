package com.example.hamster.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        activeMapper.insertSelective(active);
    }

    /**
     * if getActiveBean's time params is null, get max lapCount, else get lapCount between two time
     */
    public Integer findLapCount(GetActiveBean getActiveBean) {

        Integer lapCount = 0;

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date startTime = null;
        Date endTime = null;

        if (null != getActiveBean.getStartDate() && null != getActiveBean.getEndDate()) {
            try {
                startTime = dateformat.parse(getActiveBean.getStartDate());
                endTime = dateformat.parse(getActiveBean.getEndDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            List<Active> activeList = activeMapper.selectLapCountByDateDesc(getActiveBean.getHamsterId(), startTime, endTime);

            int maxCount = activeList.get(0).getLapCount();
            int mixCount = activeList.get(activeList.size() - 1).getLapCount();

            lapCount = maxCount - mixCount;

        } else {

            Active active = activeMapper.selectMapLapCount(getActiveBean.getHamsterId());

            lapCount = active.getLapCount();
        }

        return lapCount;
    }

    public List<Map<String, Object>> getLapCountByMonth(Integer hamsterId) {
        List<Map<String, Object>> lapCountByMonthList = activeMapper.selectLapCountByMonth(hamsterId);
        return lapCountByMonthList;
    }


    public Map<String, Object> getLapCountByDay(Integer hamsterId) {
    	
    	LocalDateTime nowTime = LocalDateTime.now();
    	LocalDateTime batchTime = LocalDateTime.now().withHour(7).withMinute(0).withSecond(0).withNano(0);
    	LocalDateTime targetTime = null;
    	//判断查询时是否已完成当天 圈数统计
    	if(nowTime.isBefore(batchTime)) {
    		//执行batch之前，统计从昨天7点到目前为止圈数
    		targetTime = LocalDateTime.now().minusDays(1).withHour(7).withMinute(0).withSecond(0).withNano(0);
    	}else{
    		//执行batch之后
    		targetTime = batchTime;
    	}
    	
    	Map<String, Object> result = activeMapper.selectLapCountByDay(hamsterId,targetTime);;
    	
		return result;
    }

    public  List<Map<String, Object>> getScatterByHour(Integer hamsterId) {
        List<Map<String, Object>> scatterByHour = activeMapper.selectScatterByHour(hamsterId);
        return scatterByHour;
    }


}
