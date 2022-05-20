package com.example.hamster.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LapCountDayly implements Serializable{
	
	private Integer hamsterId;
	
	private LocalDate targerDate;
	
	private Integer totalLap;
	
	private Date insertDateTime;
}
