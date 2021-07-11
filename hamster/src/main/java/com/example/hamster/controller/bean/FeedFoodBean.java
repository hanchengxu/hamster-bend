package com.example.hamster.controller.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeedFoodBean {

	private Integer hamsterId;

	//unit: sec
	private Integer feedTime;
}
