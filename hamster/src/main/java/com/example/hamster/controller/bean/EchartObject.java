package com.example.hamster.controller.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EchartObject {
	
	private List<?> xAxis;
	
	private List<?> yAxis;
	
	private List<?> series;

}
