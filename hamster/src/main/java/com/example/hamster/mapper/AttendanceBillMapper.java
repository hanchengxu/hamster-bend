package com.example.hamster.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.hamster.entity.AttendanceBill;

public interface AttendanceBillMapper {

	@Insert("INSERT INTO public.attendance_bill " +
			"(report_date, work_ordinary_hours_monthly, work_weekend_hours_monthly, " +
			"work_hours_monthly, work_ordinary_bill_monthly, work_weekend_bill_monthly, " +
			"work_bill_monthly, trave_bill_monthly, additional_total, bill_monthly, " +
			"insert_datetime, update_datetime) " +
			"VALUES(#{bill.reportDate}, #{bill.workOrdinaryHoursMonthly}, #{bill.workWeekendHoursMonthly}, #{bill.workHoursMonthly},"
			+ "#{bill.workOrdinaryBillMonthly}, #{bill.workWeekendBillMonthly}, #{bill.workBillMonthly}, "
			+ "#{bill.traveBillMonthly}, #{bill.additionalTotal}, #{bill.billMonthly}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
	int insertOne(@Param("bill") AttendanceBill bill);

	@Select("SELECT * FROM attendance_bill WHERE report_date = #{reportDate}")
	AttendanceBill selectByReportDate(@Param("reportDate") String reportDate);

	@Delete("DELETE FROM attendance_bill WHERE report_date = #{reportDate}")
	int deleteBillReport(@Param("reportDate") String reportDate);

	@Select("select distinct report_date::varchar from attendance_bill order by report_date")
	List<String> selectAllReportsDate();

}
