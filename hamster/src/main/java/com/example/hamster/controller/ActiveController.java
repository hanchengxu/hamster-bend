package com.example.hamster.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.example.hamster.controller.bean.GetActiveBean;
import com.example.hamster.controller.bean.IncrementLapBean;
import com.example.hamster.controller.bean.SaveActiveBean;
import com.example.hamster.entity.Active;
import com.example.hamster.service.ActiveService;
import com.example.hamster.service.TandHService;
import com.zaxxer.hikari.HikariDataSource;

@RestController
@RequestMapping("/api")
public class ActiveController {

	@Autowired
	ActiveService activeService;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private TandHService tAndHService;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static final Logger logger = LoggerFactory.getLogger(ActiveController.class);

	/**
	 * save lap_count from mqtt
	 */
	@RequestMapping("/noauth/saveActive")
	public String saveActive(@RequestBody SaveActiveBean activeBean) {

		Active active = new Active();
		active.setHamsterId(activeBean.getMsg().get(0));
		active.setLapCount(activeBean.getMsg().get(1));
		active.setInsertDateTime(new Date());
		active.setInsertUser("system");

		activeService.insertOne(active);

		return "OK";
	}

	/**
	 * get laps between a time quantum getActiveBean.startDate and endDate String
	 * format: yyyy-MM-dd hh:mm:ss
	 *
	 * @param getActiveBean
	 * @return
	 */
	@RequestMapping(value = "/noauth/getLapCount", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String getlapCount(@RequestBody GetActiveBean getActiveBean) {

		Integer lapCount = activeService.findLapCount(getActiveBean);

		return "{\"lapCount\":" + lapCount + "}";
	}

	/**
	 * get total laps from active table by hamsterId
	 *
	 * @param hamsterId
	 * @return
	 */
	@RequestMapping(value = "/noauth/getMaxLapCount", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getMaxLapCount(@RequestParam(name = "hamsterId", required = true) Integer hamsterId) {

		if (null == hamsterId) {
			return null;
		}

		GetActiveBean bean = new GetActiveBean();
		bean.setHamsterId(hamsterId);

		Integer lapCount = activeService.findLapCount(bean);

		return "{\"lapCount\":" + lapCount + "}";
	}

	@RequestMapping(value = "/noauth/getLapCountByMonth", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getLapCountByMonth(@RequestParam(name = "hamsterId", required = true) Integer hamsterId) {

		List<Map<String, Object>> lapList = activeService.getLapCountByMonth(hamsterId);

		List<String> xAxisData = new ArrayList<String>();
		List<Integer> seriesData = new ArrayList<Integer>();
		for (Map<String, Object> map : lapList) {
			xAxisData.add((String) map.get("month"));
			seriesData.add((Integer) map.get("total"));
		}
		String seriesDataStr = JSON.toJSONString(seriesData);
		String xAxisDataStr = JSON.toJSONString(xAxisData);
		// echart JSON
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

	@GetMapping(value = "/noauth/getLapCountByDay/{hamsterId}",produces = "application/json;charset=utf-8")
	public String getLapCountByDay(@PathVariable Integer hamsterId) {

		Map<String, Object> lapResult = activeService.getLapCountByDay(hamsterId);

		String caseAvgTemperature = tAndHService.getCaseAvgTemperature(hamsterId);

		// echart JSON
		StringBuffer bf = new StringBuffer();
		bf.append("{");
		bf.append("\"xAxis\": ");
		bf.append(lapResult.get("xAxis").toString()).append(",");
		bf.append("\"series\": ");
		bf.append(lapResult.get("series").toString()).append(",");
		bf.append("\"caseAvgTemperature\": ");
		bf.append(caseAvgTemperature);
		bf.append("}");

		return bf.toString();
	}


	@GetMapping(value = "/noauth/getHourAvgChart/{hamsterId}", produces = "application/json;charset=utf-8")
	public String getHourAvgChart(@PathVariable Integer hamsterId) {
		List<Map<String, Object>> lapList = activeService.getScatterByHour(hamsterId);
		List<String> xAxisData = new ArrayList<String>();
		List<Integer> seriesData = new ArrayList<Integer>();
		lapList.stream().forEach(mapData -> {
			xAxisData.add((String) mapData.get("day_time"));
			seriesData.add((Integer) mapData.get("lap_count"));
		});

		String seriesDataStr = JSON.toJSONString(seriesData);
		String xAxisDataStr = JSON.toJSONString(xAxisData);
		// echart JSON
		StringBuffer bf = new StringBuffer();
		bf.append("{");
		bf.append("\"xAxis\": ");
		bf.append(xAxisDataStr).append(",");
		bf.append("\"series\": ");
		bf.append(seriesDataStr);
		bf.append("}");

		return bf.toString();
	}

	//运动增量柱状图
	@GetMapping(value = "/noauth/getHourChart/{hamsterId}", produces = "application/json;charset=utf-8")
	public Map<Object, Object> getHourChart(@PathVariable Integer hamsterId) {

		Map<Object, Object> dayly = redisTemplate.opsForHash().entries("daylyIncrement_"+hamsterId);

		return dayly;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "testPool")
	public String testPool() throws ClassNotFoundException {
		Class clazz = Class.forName("com.zaxxer.hikari.HikariDataSource");
		// load from spring
		HikariDataSource dataSource = (HikariDataSource) applicationContext.getBean(clazz);
		if (null != dataSource.getPoolName() && dataSource.getPoolName().equals("TestPool")) {
			logger.info("TestPool:same DataPool...");
		} else {
			dataSource.setMaximumPoolSize(2);
			dataSource.setMinimumIdle(1);
			// 超过10s 如果还无法从连接池获取连接，那么就会报错
			dataSource.setConnectionTimeout(1000 * 10);
			dataSource.setPoolName("TestPool");
			logger.info("difference DataPool...");
		}

		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
//    	throw new RuntimeException("Test Exception");
		try {
			conn = dataSource.getConnection();
			String sql = "select * from active order by insert_date_time desc limit 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
//    		while(rs.next()) {
//    			int activeId = rs.getInt(1);
//    			System.out.println(activeId);
//    		}

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

	/**
	 * increm lapcount from mqtt broker
	 *
	 * @param bean
	 */
	@PostMapping(value = "/noauth/incrementLap")
	public void incrementLap(@RequestBody IncrementLapBean bean) {

		if (null != bean.getHamsterId()) {
			redisTemplate.opsForValue().increment(bean.getHamsterId().toString());
		}

	}

}
