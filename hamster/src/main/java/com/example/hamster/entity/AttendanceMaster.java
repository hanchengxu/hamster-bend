package com.example.hamster.entity;

import java.util.Date;

import lombok.Data;

@Data
public class AttendanceMaster {

	private Integer id;
	private String ItemName;
	private String itemValue;
	private String itemDesc;
	private Date insertDatetime;
	private Date updateDatetime;
}
