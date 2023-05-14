package com.example.hamster.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.constant.CommonResponse;
import com.example.hamster.constant.ResponseCode;
import com.example.hamster.entity.AttendanceAdditionalData;
import com.example.hamster.service.AdditionalDataService;

@RestController
@RequestMapping("/api")
public class AdditonalDataController {

	@Autowired
	AdditionalDataService additonalDataService;

	private static final Logger logger = LoggerFactory.getLogger(AdditonalDataController.class);

	@GetMapping(value = "/noauth/getAdditionalDataList/{workDay}", produces = "application/json;charset=utf-8")
	public CommonResponse getAdditionalDataList(@PathVariable String workDay) {

		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<AttendanceAdditionalData> targetList= additonalDataService.findAdditonalDatas(LocalDate.parse(workDay,ft));

		logger.debug(targetList.toString());

		return new CommonResponse(ResponseCode.STATSU_OK, null, targetList);

	}
}
