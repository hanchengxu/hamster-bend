package com.example.hamster.service;

import java.time.LocalDate;
import java.util.List;

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

	public List<AttendanceAdditionalData> findAdditonalDatas(LocalDate workDay) {

		List<AttendanceAdditionalData> additionalDataList = additionalDataMapper
				.selectAttendanceAdditionalDataByworkDay(workDay);

		return additionalDataList;
	}

	public List<AttendanceAdditionalData> findAdditonalDatasByMonth(String yearMonth) {

		List<AttendanceAdditionalData> additionalDataList = additionalDataMapper
				.selectAttendanceAdditionalDataByMonth(yearMonth);

		return additionalDataList;
	}

}
