package com.example.hamster.controller;

import lombok.Data;

@Data
public class ResultMsg {

	private Integer code = 200 ;

	private String message;

	private Object payload;
}
