package com.example.hamster.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.hamster.controller.bean.GetActiveBean;
import com.example.hamster.controller.bean.SaveActiveBean;
import com.example.hamster.entity.Active;
import com.example.hamster.service.ActiveService;
import com.zaxxer.hikari.HikariDataSource;

import jdk.jshell.spi.ExecutionControl.RunException;

@RestController
public class ActiveController {

    @Autowired
    ActiveService activeService;

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * save lap_count from mqtt
     */
    @RequestMapping("saveActive")
    public String saveActive(@RequestBody SaveActiveBean activeBean) {

        Active active = new Active(activeBean.getMsg().get(0),activeBean.getMsg().get(1),new Date(),"system");

        activeService.insertOne(active);

        return "OK";
    }

    /**
     * get laps between a time quantum
     * getActiveBean.startDate and endDate String format: yyyy-MM-dd hh:mm:ss
     * @param getActiveBean
     * @return
     */
    @RequestMapping(value= "getLapCount",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String getlapCount(@RequestBody GetActiveBean getActiveBean) {

        Integer lapCount = activeService.findLapCount(getActiveBean);

        return "{\"lapCount\":"+lapCount+"}";
    }

    /**
     * get total laps from active table by hamsterId
     * @param hamsterId
     * @return
     */
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


    @RequestMapping(value= "getLapCountByMonth",method=RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getLapCountByMonth() {
    	List<Map<String, Object>> lapList = activeService.getLapCountByMonth(1);

    	List<String> xAxisData = new ArrayList<String>();
    	List<Integer> seriesData = new ArrayList<Integer>();
    	for(Map<String, Object> map: lapList) {
    		xAxisData.add((String)map.get("month"));
    		seriesData.add((Integer)map.get("total"));
    	}
    	String seriesDataStr = JSON.toJSONString(seriesData);
    	String xAxisDataStr = JSON.toJSONString(xAxisData);
    	//echart JSON
    	StringBuffer bf = new StringBuffer();
    	bf.append("{");
    	bf.append("\"xAxis\": {\"data\":");
    	bf.append(xAxisDataStr).append("},");
    	bf.append("\"yAxis\": {},");
    	bf.append("\"series\": [{\"name\": \"圈数\",\"type\": \"bar\",\"data\":");
    	bf.append(seriesDataStr).append("}]");
    	bf.append("}");

    	return bf.toString();
    }

    @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@RequestMapping(value="testPool")
    public String testPool() throws ClassNotFoundException {
    	Class clazz = Class.forName("com.zaxxer.hikari.HikariDataSource");
    	HikariDataSource dataSource = (HikariDataSource) applicationContext.getBean(clazz);
    	Connection conn = null;
    	ResultSet rs = null;
    	Statement stmt = null;
//    	throw new RuntimeException("Test Exception");
    	try {
    		conn = dataSource.getConnection();
    		String sql ="select * from active order by insert_date_time desc limit 1";
    		stmt =conn.createStatement();
    		rs=stmt.executeQuery(sql);
    		while(rs.next()) {
    			int activeId = rs.getInt(1);
    			System.out.println(activeId);
    		}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "{1}";
    }

}
