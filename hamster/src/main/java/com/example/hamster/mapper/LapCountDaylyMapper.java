package com.example.hamster.mapper;

import org.apache.ibatis.annotations.Insert;

import com.example.hamster.entity.LapCountDayly;

public interface LapCountDaylyMapper {

	@Insert("insert into lap_count_dayly(hamster_id,target_date,total_lap,insert_date_time)"
			+ "values(#{hamsterId},#{targerDate},#{totalLap},now())" 
			+ "on conflict(hamster_id,target_date) "
			+ "do update set total_lap = #{totalLap}, insert_date_time = now()")
	int insert(LapCountDayly daylaylap);
}
