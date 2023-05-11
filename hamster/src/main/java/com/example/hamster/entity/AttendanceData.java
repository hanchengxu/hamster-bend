package com.example.hamster.entity;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AttendanceData {

	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+9")
	private LocalDate workDay;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+9")
	private Date startTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+9")
	private Date endTime;
	private String workUserName;
	private Date insertDatetime;
	private Date updateDatetime;

}