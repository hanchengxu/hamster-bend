package com.example.hamster.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.AttendanceAdditionalData;

public interface AttendanceAdditionalDataMapper {

	@Insert("INSERT INTO attendance_additional_data (work_day,price,additional_desc) "
			+ "VALUES (#{additionalData.workDay},#{additionalData.price},#{additionalData.additionalDesc})")
	 int insert(@Param("additionalData") AttendanceAdditionalData additionalData);

	 @Select("select additional_id,work_day::varchar,price,additional_desc "
	 		+ "from  attendance_additional_data where work_day = #{workDay}")
	public List<Map<String, Object>> selectAttendanceAdditionalDataByworkDay(@Param("workDay") LocalDate workDay);

}
