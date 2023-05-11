package com.example.hamster.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hamster.entity.AttendanceData;
import com.example.hamster.mapper.AttendanceDataMapper;

@Service
public class AttendanceDataService {

	@Autowired
	AttendanceDataMapper mapper;

	@Transactional(rollbackFor = Exception.class)
	public AttendanceData insertUpdateStartTime(AttendanceData data) {

		data.setStartTime(new Date());
		mapper.insertStartTime(data);

		return getAttendanceData(data.getWorkDay());

	}

	@Transactional(rollbackFor = Exception.class)
	public AttendanceData insertUpdateEndTime(AttendanceData data) {

		data.setEndTime(new Date());
		mapper.insertEndTime(data);

		return getAttendanceData(data.getWorkDay());

	}

	public AttendanceData getAttendanceData(LocalDate workDay) {
		return mapper.selectAttendanceData(workDay);
	}
}
