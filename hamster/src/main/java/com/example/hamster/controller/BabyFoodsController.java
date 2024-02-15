package com.example.hamster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hamster.entity.BabyFoods;
import com.example.hamster.service.BabyFoodsService;

@RestController
@RequestMapping("/api")
public class BabyFoodsController {

	@Autowired
	private BabyFoodsService babyFoodsService;

	@PostMapping(value = "/noauth/babyFoodsAdd", produces = "application/json;charset=utf-8")
	public String babyFoodsAdd(BabyFoods babyFoods) {

		List<BabyFoods> foodsList = babyFoodsService.insertBabyFoods(babyFoods);
		if (foodsList.size() >0) {
			return "success";
		}
		return "false";
		}

	@GetMapping(value = "/noauth/babyFoodsList/{Date}", produces = "application/json;charset=utf-8")
	public List<BabyFoods> babyFoodsList(@PathVariable(name = "Date") String mealDate) {

		List<BabyFoods> foodsList = babyFoodsService.selectList(mealDate);
		System.out.println(foodsList);

		return foodsList;
	}

}
