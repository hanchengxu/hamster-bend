package com.example.hamster.controller.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetActiveBean {

    private Integer hamsterId;

    private String startDate;

    private String endDate;
}
