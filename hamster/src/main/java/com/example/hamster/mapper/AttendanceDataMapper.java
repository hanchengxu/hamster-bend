package com.example.hamster.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
			"(work_day, end_time, work_user_name, work_hours)" +
			"VALUES(#{additionalData.workDay}, #{additionalData.endTime},"
			+ " #{additionalData.workUserName}, #{additionalData.workHours}) ON CONFLICT(work_day) do update "
			+ "set end_time=EXCLUDED.end_time ,update_datetime = EXCLUDED.end_time, work_hours = EXCLUDED.work_hours "
			+ "where attendance_data.end_time <= EXCLUDED.end_time or attendance_data.end_time is null")
	int insertEndTime(@Param("additionalData") AttendanceData attendanceData);


	@Update("UPDATE public.attendance_data SET work_hours=#{attendanceData.workHours}, update_datetime=#{attendanceData.updateDatetime} where work_day = #{attendanceData.workDay}")
	int updateWorkHours(@Param("attendanceData") AttendanceData attendanceData);

	@Select("SELECT work_day, start_time, end_time, work_user_name, insert_datetime, update_datetime, work_hours from public.attendance_data where work_day = #{workDay}")
	AttendanceData selectAttendanceData(@Param("workDay") LocalDate workDay);

	@Select("SELECT work_day, start_time, end_time, work_user_name, insert_datetime, update_datetime, work_hours "
			+ "from public.attendance_data "
			+ "where to_char(work_day,'yyyy-MM') = #{yearMonth} and work_hours is not null "
			+ "order by work_day")
	List<AttendanceData> selectAttendanceDataByYearMonth(@Param("yearMonth") String yearMonth);

}
