package com.example.hamster.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hamster.entity.AttendanceAdditionalData;
import com.example.hamster.mapper.AttendanceAdditionalDataMapper;

@Service
public class AdditionalDataService {

	@Autowired
	AttendanceAdditionalDataMapper additionalDataMapper;

	public void insertOne(AttendanceAdditionalData additionalData) {
		additionalDataMapper.insert(additionalData);
	}

	public List<Map<String,Object>> findAdditonalDatas(LocalDate workDay) {

		List<Map<String,Object>> additionalDataList = additionalDataMapper
				.selectAttendanceAdditionalDataByworkDay(workDay);

		AttendanceAdditionalData ad= AttendanceAdditionalData.builder().
				workDay(new Date()).
				price((float) 12.4).
				additionalDesc("asd").
				build();

		return additionalDataList;
	}

}
