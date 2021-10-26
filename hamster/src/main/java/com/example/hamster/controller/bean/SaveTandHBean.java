package com.example.hamster.controller.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SaveTandHBean{

	private Integer hamsterId;

    private Integer caseT;//环境温度

    private Integer caseH;//环境湿度

    private Integer heaterT;//加热垫温度
}