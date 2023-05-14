package com.example.hamster.entity;


import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttendanceAdditionalData {

	private Integer additionalId;
	private Date workDay;
	private Double price;
	private String additionalDesc;
}
