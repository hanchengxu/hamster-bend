package com.example.hamster.entity;

import java.util.Date;

import lombok.Data;

@Data
public class BabyFoods {

	private Integer id;
	// 日期
	private String mealDate;
	// 一日三餐
	private Integer mealType;

	private String foods;
	private boolean isInput;
	private Date createDate;
	private Date updateDate;
}
