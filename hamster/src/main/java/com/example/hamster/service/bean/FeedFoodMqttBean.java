package com.example.hamster.service.bean;

import lombok.Data;

@Data
public class FeedFoodMqttBean {

	private String topic = "feedFood";

	private String payload;

	private Integer qos = 1;

	private Boolean retain = false;

	private String clientid = "b-end";
}
