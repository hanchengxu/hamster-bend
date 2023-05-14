package com.example.hamster.service;

import static one.cafebabe.businesscalendar4j.BusinessCalendar.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hamster.entity.AttendanceAdditionalData;
import com.example.hamster.entity.AttendanceBill;
import com.example.hamster.entity.AttendanceData;
import com.example.hamster.entity.AttendanceMaster;
import com.example.hamster.mapper.AttendanceBillMapper;

import one.cafebabe.businesscalendar4j.BusinessCalendar;

@Service
public class AttendanceBillService {

	@Autowired
	AttendanceBillMapper mapper;

	@Autowired
	AdditionalDataService additonalDataService;

	@Autowired
	AttendanceDataService dServicel;

	@Autowired
	AttendanceMasterService masterService;

	public AttendanceBill selectAttendanceBillByReportDate(String reportDate) {

		return mapper.selectByReportDate(reportDate);
	}

	@Transactional(rollbackFor = Exception.class)
	public AttendanceBill createReport(String reportDate) {

		AttendanceBill oldBill = selectAttendanceBillByReportDate(reportDate);

		if (null != oldBill) {
			// 当月有报表，先删除旧报表再生成
			mapper.deleteBillReport(reportDate);
		}

		AttendanceBill bill = new AttendanceBill();

		// 获取master配置项
		List<AttendanceMaster> masterList = masterService.selectAllMaster();

		List<AttendanceData> attendanceList = dServicel.selectAttendanceDataByYearMonth(reportDate);

		Double workOrdinaryHoursMonthly = 0.d;//平日总时长
		Double workWeekendHoursMonthly = 0.d;//假日总时长
		Double workHoursMonthly = 0.d;// 月总时长
		Double workBillMonthly = 0.d;// 月工作金额

		// 日本节假日判断工具
		BusinessCalendar businessCalendar = BusinessCalendar.newBuilder()
				.on(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY).holiday("週末")
				.holiday(JAPAN.PUBLIC_HOLIDAYS).locale(Locale.JAPAN).build();

		// 月工作时间计算
		for (AttendanceData attendance : attendanceList) {
			LocalDate workDay = attendance.getWorkDay();
			if (businessCalendar.isHoliday(workDay)) {
				workWeekendHoursMonthly = workWeekendHoursMonthly + attendance.getWorkHours();
			} else {
				workOrdinaryHoursMonthly = workOrdinaryHoursMonthly + attendance.getWorkHours();
			}
		}
		workHoursMonthly = workWeekendHoursMonthly + workOrdinaryHoursMonthly;

		// 平日 工作单价
		String houtUnitPrice = masterList.stream().filter(master -> master.getItemName().equals("hour_unit_price"))
				.findFirst().get().getItemValue();
		String holidayHoutUnitPrice = masterList.stream()
				.filter(master -> master.getItemName().equals("holiday_hour_unit_price")).findFirst().get()
				.getItemValue();
		String daylyTraveExpenses = masterList.stream()
				.filter(master -> master.getItemName().equals("dayly_trave_expenses")).findFirst().get().getItemValue();

		// 平日工作总金额
		Double workOrdinaryBillMonthly = Double.valueOf(houtUnitPrice) * workOrdinaryHoursMonthly;
		Double workWeekendBillMonthly = Double.valueOf(holidayHoutUnitPrice) * workWeekendHoursMonthly;

		workBillMonthly = workOrdinaryBillMonthly + workWeekendBillMonthly;

		// 车费计算
		Double traveBillMonthly = Double.valueOf(daylyTraveExpenses) * attendanceList.size();

		// 根据月份获取 附加费用信息

		List<AttendanceAdditionalData> targetList = additonalDataService.findAdditonalDatasByMonth(reportDate);

		Double additionalTotal = 0.d;

		for (AttendanceAdditionalData additionalData : targetList) {
			additionalTotal = additionalTotal + additionalData.getPrice();
		}

		Double billMonthly = 0.d;

		billMonthly = workBillMonthly + traveBillMonthly + additionalTotal;


		bill.setReportDate(reportDate);
		bill.setWorkOrdinaryHoursMonthly(workOrdinaryHoursMonthly);
		bill.setWorkOrdinaryBillMonthly(workOrdinaryBillMonthly);
		bill.setWorkWeekendHoursMonthly(workWeekendHoursMonthly);
		bill.setWorkWeekendBillMonthly(workWeekendBillMonthly);

		bill.setWorkHoursMonthly(workHoursMonthly);

		bill.setWorkBillMonthly(workBillMonthly);
		bill.setTraveBillMonthly(traveBillMonthly);
		bill.setAdditionalTotal(additionalTotal);

		bill.setBillMonthly(billMonthly);

		if (1 == mapper.insertOne(bill)) {
			return selectAttendanceBillByReportDate(reportDate);
		}

		return null;
	}
}
