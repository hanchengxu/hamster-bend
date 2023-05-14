package com.example.hamster.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hamster.entity.AttendanceData;
import com.example.hamster.mapper.AttendanceDataMapper;
import com.example.hamster.utils.DateUtils;

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

		AttendanceData old = getAttendanceData(data.getWorkDay());

		// 取当天上班时间
		Date startTime = old.getStartTime();

		// 设定下班时间
		data.setEndTime(new Date());
		// 计算工作小时 小于15 分钟 为整点， 小于45分钟 为 30分，大于 45分 增加1小时
		data.setWorkHours(DateUtils.countWorkHours(startTime, data.getEndTime()));

		mapper.insertEndTime(data);

		AttendanceData tt= getAttendanceData(data.getWorkDay());


		return getAttendanceData(data.getWorkDay());

	}

	public AttendanceData countWorkHours(LocalDate workDay) {
		AttendanceData data = getAttendanceData(workDay);

		if(null != data.getEndTime()) {
			Double hours = DateUtils.countWorkHours(data.getStartTime(),data.getEndTime());

			data.setWorkHours(hours);
			data.setUpdateDatetime(new Date());
			mapper.updateWorkHours(data);
			return data;
		}
		return null;
	}

	public AttendanceData getAttendanceData(LocalDate workDay) {
		return mapper.selectAttendanceData(workDay);
	}

	public List<AttendanceData> selectAttendanceDataByYearMonth(String yearMonth) {
		return mapper.selectAttendanceDataByYearMonth(yearMonth);
	}
}
