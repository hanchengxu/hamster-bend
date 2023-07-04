package com.example.hamster.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
import com.example.hamster.entity.AttendanceAdditionalData;
import com.example.hamster.service.AdditionalDataService;
import com.example.hamster.service.AttendanceBillService;

@RestController
@RequestMapping("/api")
public class AdditonalDataController {

	@Autowired
	AdditionalDataService additonalDataService;
	@Autowired
	AttendanceBillService billService;

	private static final Logger logger = LoggerFactory.getLogger(AdditonalDataController.class);

	@GetMapping(value = "/noauth/getAdditionalDataList/{workDay}", produces = "application/json;charset=utf-8")
	public CommonResponse getAdditionalDataList(@PathVariable String workDay) {

		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<AttendanceAdditionalData> targetList= additonalDataService.findAdditonalDatas(LocalDate.parse(workDay,ft));

		logger.debug(targetList.toString());

		return new CommonResponse(ResponseCode.STATSU_OK, null, targetList);

	}

	@GetMapping(value = "/noauth/getAdditionalDataMonthly/{workMonth}", produces = "application/json;charset=utf-8")
	public CommonResponse getAdditionalDataMonthly(@PathVariable String workMonth) {
		List<AttendanceAdditionalData> targetList= additonalDataService.findAdditonalDatasByMonth(workMonth);

		logger.debug(targetList.toString());

		return new CommonResponse(ResponseCode.STATSU_OK, null, targetList);

	}

	@PostMapping(value ="/noauth/saveAdditionalData", produces = "application/json;charset=utf-8")
	public CommonResponse saveAdditionalData(@RequestBody AttendanceAdditionalData saveData) {

		additonalDataService.insertOne(saveData);

		//获得需要存储的附加信息所在月
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		String insertMonth = df.format(saveData.getWorkDay());
		//更新报表数据
		billService.createReport(insertMonth);

		// insert之后获取当月所有信息
		List<AttendanceAdditionalData> targetList= additonalDataService.findAdditonalDatasByMonth(insertMonth);
		return new CommonResponse(ResponseCode.STATSU_OK, null, targetList);

	}
}
