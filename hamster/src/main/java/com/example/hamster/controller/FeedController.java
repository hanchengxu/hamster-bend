package com.example.hamster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.controller.bean.FeedFoodBean;
import com.example.hamster.service.FeedFoodService;

@RestController
public class FeedController {

	@Autowired
	FeedFoodService service;

	@RequestMapping(value = "feedFood", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public ResultMsg feedFood(@RequestBody FeedFoodBean feedFoodBean){

		ResultMsg result = new ResultMsg();
		if (null == feedFoodBean.getHamsterId()) {
			throw new RuntimeException("need HamsterId");
		}else {
			service.feedFood(feedFoodBean);
		}


		return result;
	}
}
