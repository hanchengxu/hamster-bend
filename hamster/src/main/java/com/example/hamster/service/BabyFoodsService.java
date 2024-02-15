package com.example.hamster.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hamster.entity.BabyFoods;
import com.example.hamster.mapper.BabyFoodsMapper;

@Service
public class BabyFoodsService {

	@Autowired
	BabyFoodsMapper mapper;

	@Transactional(rollbackFor = Exception.class)
	public List<BabyFoods> insertBabyFoods(BabyFoods babyFoods) {

		babyFoods.setCreateDate(new Date());
		babyFoods.setUpdateDate(new Date());
		mapper.insertBabyFoods(babyFoods);

		return mapper.selectBabyFoodsList(babyFoods.getMealDate());
	}

	public List<BabyFoods> selectList(String mealDate) {

		return mapper.selectBabyFoodsList(mealDate);
	}

}
