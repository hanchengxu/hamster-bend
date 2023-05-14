package com.example.hamster.entity;

import java.util.Date;

import lombok.Data;

@Data
public class AttendanceBill {

	private Integer id;
	private String reportDate;//yyyy-MM

	private Double workOrdinaryHoursMonthly;
	private Double workWeekendHoursMonthly;
	private Double workHoursMonthly;

	private Double workOrdinaryBillMonthly;
	private Double workWeekendBillMonthly;
	private Double workBillMonthly;

	private Double traveBillMonthly;
	private Double additionalTotal;
	private Double billMonthly;
	private Date insertDatetime;
	private Date updateDatetime;
}
