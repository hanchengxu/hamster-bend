package com.example.hamster.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.BabyFoods;

public interface BabyFoodsMapper {

	@Insert("INSERT INTO public.baby_foods(meal_date, meal_type,foods, is_input , create_date, update_date) "
			+ "VALUES(#{babyFoods.mealDate},#{babyFoods.mealType},#{babyFoods.foods},#{babyFoods.isInput},#{babyFoods.createDate},#{babyFoods.updateDate})")
	int insertBabyFoods(@Param("babyFoods") BabyFoods babyFoods);

	int updatetBabyFoods(@Param("babyFoods") BabyFoods babyFoods);

	@Select("SELECT * from public.baby_foods where meal_date=#{mealDate} ")
	List<BabyFoods> selectBabyFoodsList(@Param("mealDate") String mealDate);

}
