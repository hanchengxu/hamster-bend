package com.example.hamster.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.constant.CommonResponse;
import com.example.hamster.constant.ResponseCode;
import com.example.hamster.entity.AttendanceData;
import com.example.hamster.service.AttendanceDataService;

@RestController
@RequestMapping("/api")
public class AttendanceDataController {

	@Autowired
	AttendanceDataService attendanceDataService;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceDataController.class);

	@PostMapping(value = "/noauth/saveStartWorkTime", produces = "application/json;charset=utf-8")
	public CommonResponse saveStartWorkTime(@RequestBody AttendanceData bean) {

		AttendanceData result = attendanceDataService.insertUpdateStartTime(bean);

		return new CommonResponse(ResponseCode.STATSU_OK,null,result);

	}

	@PostMapping(value = "/noauth/saveEndWorkTime", produces = "application/json;charset=utf-8")
	public CommonResponse saveEndWorkTime(@RequestBody AttendanceData bean) {


		AttendanceData result = attendanceDataService.insertUpdateEndTime(bean);

		return new CommonResponse(ResponseCode.STATSU_OK,null,result);
	}

	@GetMapping(value = "/noauth/getAttendanceData/{workDay}", produces = "application/json;charset=utf-8")
	public CommonResponse getAttendanceData(@PathVariable String workDay) {

		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return new CommonResponse(ResponseCode.STATSU_OK, null, attendanceDataService.getAttendanceData(LocalDate.parse(workDay,ft)));
	}

}
