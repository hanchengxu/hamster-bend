package com.example.hamster.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.example.hamster.controller.ResultMsg;
import com.example.hamster.controller.bean.SaveTandHBean;
import com.example.hamster.entity.CaseHumidity;
import com.example.hamster.entity.CaseTemperature;
import com.example.hamster.entity.HeaterTemperature;
import com.example.hamster.mapper.CaseHumidityMapper;
import com.example.hamster.mapper.CaseTemperatureMapper;
import com.example.hamster.mapper.HeaterTemperatureMapper;

@Service
public class TandHService {



	@Autowired
	CaseTemperatureMapper caseTMapper;

	@Autowired
	CaseHumidityMapper caseHMapper;

	@Autowired
	HeaterTemperatureMapper heaterTMapper;


	public ResultMsg save(SaveTandHBean saveTandHBean) {
		ResultMsg result = new ResultMsg();

		if(null != saveTandHBean.getCaseT()) {
			CaseTemperature entity = new CaseTemperature();

			entity.setHamsterId(saveTandHBean.getHamsterId());
			entity.setCt(new BigDecimal(saveTandHBean.getCaseT()));
			entity.setCtTime(new Date());
			entity.setInsertDateTime(new Date());
			entity.setUpdateDateTime(new Date());
			entity.setInsertUser("admin");
			entity.setUpdateUser("admin");

			caseTMapper.insertSelective(entity);
		}

		if(null != saveTandHBean.getCaseH()) {
			CaseHumidity entity = new CaseHumidity();

			entity.setHamsterId(saveTandHBean.getHamsterId());
			entity.setCh(new BigDecimal(saveTandHBean.getCaseH()));
			entity.setChTime(new Date());
			entity.setInsertDateTime(new Date());
			entity.setUpdateDateTime(new Date());
			entity.setInsertUser("admin");
			entity.setUpdateUser("admin");

			caseHMapper.insertSelective(entity);
		}

		if(null != saveTandHBean.getHeaterT()) {
			HeaterTemperature entity = new HeaterTemperature();

			entity.setHamsterId(saveTandHBean.getHamsterId());
			entity.setHamsterId(saveTandHBean.getHamsterId());
			entity.setHt(new BigDecimal(saveTandHBean.getHeaterT()));
			entity.setHtTime(new Date());
			entity.setInsertDateTime(new Date());
			entity.setUpdateDateTime(new Date());
			entity.setInsertUser("admin");
			entity.setUpdateUser("admin");

			heaterTMapper.insertSelective(entity);
		}

		return result;
	}
	
	public String getCaseAvgTemperature(Integer hamsterId) {
		
		List<Float> list = caseTMapper.getAvgTemperature(hamsterId);
		
		return JSON.toJSONString(list);
	}

}
