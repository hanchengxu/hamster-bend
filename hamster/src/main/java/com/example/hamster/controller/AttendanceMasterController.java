package com.example.hamster.controller;

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
import com.example.hamster.entity.AttendanceMaster;
import com.example.hamster.service.AttendanceMasterService;

@RestController
@RequestMapping("/api")
public class AttendanceMasterController {

	@Autowired
	AttendanceMasterService masterService;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceMasterController.class);


	@GetMapping(value = "/noauth/getMasterList", produces = "application/json;charset=utf-8")
	public CommonResponse getMasterList() {

		List<AttendanceMaster> targetList= masterService.selectAllMaster();
		logger.debug(targetList.toString());

		return new CommonResponse(ResponseCode.STATSU_OK,null,targetList);

	}

	@GetMapping(value = "/noauth/getMaster/{itemName}")
	public CommonResponse getMaster(@PathVariable String itemName) {

		AttendanceMaster master= masterService.selectOneMaster(itemName);
		logger.debug(master.toString());

		return new CommonResponse(ResponseCode.STATSU_OK,null,master);

	}


}
