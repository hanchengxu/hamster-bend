package com.example.hamster.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.constant.CommonResponse;
import com.example.hamster.constant.ResponseCode;
import com.example.hamster.entity.AttendanceBill;
import com.example.hamster.service.AttendanceBillService;
import com.example.hamster.utils.DateUtils;

@RestController
@RequestMapping("/api")
public class AttendanceBillController {


	@Autowired
	AttendanceBillService billService;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceBillController.class);


	@GetMapping(value = "/noauth/getReport/{reportDate}", produces = "application/json;charset=utf-8")
	public CommonResponse getReport(@PathVariable String reportDate) {

		LocalDateTime localDateTime = DateUtils.dateToLocalDateTime(new Date());

		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM");

		localDateTime.format(df);

		AttendanceBill bill = null;

		//判断是否为当月获取报表，如果是当月则 删除旧数据重新生成。如果是过去，则直接从db 获取报表
		if ( localDateTime.format(df).equals(reportDate) ) {
			bill = billService.createReport(reportDate);
		}else {
			bill = billService.selectAttendanceBillByReportDate(reportDate);
		}

		logger.debug(bill.toString());

		return new CommonResponse(ResponseCode.STATSU_OK, null, bill);

	}

	@GetMapping(value = "/noauth/getAllReportDate", produces = "application/json;charset=utf-8")
	public CommonResponse getAllReportDate() {

		return new CommonResponse(ResponseCode.STATSU_OK, null, billService.selectAllReportsDate());
	}


}
