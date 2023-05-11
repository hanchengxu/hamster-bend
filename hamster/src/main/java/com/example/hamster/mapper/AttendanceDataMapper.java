package com.example.hamster.mapper;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.AttendanceData;

public interface AttendanceDataMapper {


	@Insert("INSERT INTO public.attendance_data" +
			"(work_day, start_time, work_user_name)" +
			"VALUES(#{additionalData.workDay}, #{additionalData.startTime},"
			+ " #{additionalData.workUserName}) ON CONFLICT(work_day) do update "
			+ "set start_time=EXCLUDED.start_time ,update_datetime = EXCLUDED.start_time "
			+ "where attendance_data.start_time >= EXCLUDED.start_time or attendance_data.start_time is null")
	int insertStartTime(@Param("additionalData") AttendanceData attendanceData);


	@Insert("INSERT INTO public.attendance_data" +
			"(work_day, end_time, work_user_name)" +
			"VALUES(#{additionalData.workDay}, #{additionalData.endTime},"
			+ " #{additionalData.workUserName}) ON CONFLICT(work_day) do update "
			+ "set end_time=EXCLUDED.end_time ,update_datetime = EXCLUDED.end_time "
			+ "where attendance_data.end_time <= EXCLUDED.end_time or attendance_data.end_time is null")
	int insertEndTime(@Param("additionalData") AttendanceData attendanceData);


	@Select("SELECT * from public.attendance_data where work_day = #{workDay}")
	AttendanceData selectAttendanceData(@Param("workDay") LocalDate workDay);

}
