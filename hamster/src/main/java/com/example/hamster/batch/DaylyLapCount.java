package com.example.hamster.batch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.hamster.entity.Hamster;
import com.example.hamster.entity.HamsterExample;
import com.example.hamster.entity.LapCountDayly;
import com.example.hamster.mapper.ActiveMapper;
import com.example.hamster.mapper.HamsterMapper;
import com.example.hamster.mapper.LapCountDaylyMapper;

@Component
public class DaylyLapCount {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DaylyLapCount.class);

	@Autowired
	HamsterMapper hamsterMapper;

	@Autowired
	ActiveMapper activeMapper;

	@Autowired
	LapCountDaylyMapper daylyLapMapper;

	/**
	 * 上午07:00 为一天的开始 每天上午8点统计前一天跑圈数据 8点前查看的话，需要结合active表
	 */
	@Scheduled(cron = "0 0 08 ? * *")
	@Async
	public void daylyLapCount() {

		// 设定时间区间
		LocalDateTime toDateTime = LocalDateTime.now().withHour(7).withMinute(0).withSecond(0);
		LocalDateTime fromDateTime = toDateTime.minusDays(1);

		logger.info("fromDateTime:"+ fromDateTime+",toDateTime:"+toDateTime);

		LocalDate targetDate = LocalDate.now();

		// 选择所有hamster
		HamsterExample he = new HamsterExample();
		he.createCriteria().andHamsterIdIsNotNull();
		he.setOrderByClause("hamster_id");
		List<Hamster> hamsters = hamsterMapper.selectByExample(he);

		// 遍历hamster
		hamsters.stream().forEach((hamster) -> {

			// 统计每天跑圈数
			Map<String, Object> daylyLapResult = activeMapper.selectDayLap(hamster.getHamsterId(), fromDateTime,
					toDateTime);

			// 如果有数据,且运动量达到0以上 则保存到lap_count_dayly表
			if (null != daylyLapResult && (Integer) daylyLapResult.get("day_lap")> 0) {

				LapCountDayly daylayLap = new LapCountDayly();
				daylayLap.setHamsterId(hamster.getHamsterId());
				daylayLap.setTargerDate(targetDate);
				daylayLap.setTotalLap((Integer) daylyLapResult.get("day_lap"));

				daylyLapMapper.insert(daylayLap);
			}
		});
	}



	//初始化 历史数据用
	@Async
	public void updateTime(){

		LocalDateTime toDateTime = LocalDateTime.now().withHour(7).withMinute(0).withSecond(0);
		LocalDateTime fromDateTime = toDateTime.minusDays(1);

		LocalDate targetDate = LocalDate.now();


		for(int i=0;i<417;i++) {

			Map<String, Object> daylyLapResult = activeMapper.selectDayLap(1, fromDateTime,
					toDateTime);

			// 如果有数据则保存到lap_count_dayly表
			if (null != daylyLapResult) {

				Integer dayTotalLap = (Integer) daylyLapResult.get("day_lap");

				LapCountDayly daylayLap = new LapCountDayly();
				daylayLap.setHamsterId(1);
				daylayLap.setTargerDate(targetDate);
				daylayLap.setTotalLap(dayTotalLap);
				daylyLapMapper.insert(daylayLap);

				logger.info("fromDateTime:"+ fromDateTime+",toDateTime:"+toDateTime+" ,dayLap;"+dayTotalLap);
			}

			toDateTime = toDateTime.minusDays(1);
			fromDateTime = fromDateTime.minusDays(1);

			targetDate = targetDate.minusDays(1);
		}

	}

}
