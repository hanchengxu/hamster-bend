package com.example.hamster.entity;


import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AttendanceAdditionalData {

	private Integer additionalId;
	private Date workDay;
	private Double price;
	private String additionalDesc;
}
