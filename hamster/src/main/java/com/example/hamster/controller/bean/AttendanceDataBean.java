package com.example.hamster.controller.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AttendanceDataBean {

	private Integer id;
	private Date workDay;
	private String startTime;
	private String endTime;
	private String workUserName;
	private Date insertDatetime;
	private Date updateDatetime;

}