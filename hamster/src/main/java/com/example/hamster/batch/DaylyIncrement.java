package com.example.hamster.batch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.hamster.controller.bean.EchartObject;
import com.example.hamster.entity.Active;
import com.example.hamster.entity.Hamster;
import com.example.hamster.entity.HamsterExample;
import com.example.hamster.mapper.ActiveMapper;
import com.example.hamster.mapper.HamsterMapper;
import com.example.hamster.utils.DateUtils;

@Component
public class DaylyIncrement {

	private static final Logger logger = LoggerFactory.getLogger(DaylyIncrement.class);

	@Autowired
	ActiveMapper activeMapper;

	@Autowired
	HamsterMapper hamsterMapper;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	// 天为单位，统计跑圈数据增量
	// 定义 7:00 为一天开始与结束
	// 将计算结果缓存到redis，并不持久化到DB
	@Scheduled(cron = "0 0 07 ? * *")
	@Async
	public void daylyLapCount() {

		// end: 早上7点
		LocalDateTime dateEnd = LocalDateTime.now().withHour(7);
		// start: 昨天早上7点
		LocalDateTime dateStart = dateEnd.minusDays(1);

		LocalDate dateNow = LocalDate.now();

		// 选择所有hamster
		HamsterExample he = new HamsterExample();
		he.createCriteria().andHamsterIdIsNotNull();
		he.setOrderByClause("hamster_id");
		List<Hamster> hamsters = hamsterMapper.selectByExample(he);

		hamsters.stream().forEach((hamster) -> {

			// 倒序获取的运动信息
			List<Active> lapsList = activeMapper.selectLapCountByDate(hamster.getHamsterId(),
					DateUtils.localDateTimeToDate(dateStart), DateUtils.localDateTimeToDate(dateEnd));

			List<String> xAisData = new ArrayList<>();
			List<Integer> seriesData = new ArrayList<>();
			int tmp = 0;

			if (lapsList.size() > 0) {
				// 计算当天运动增量
				for (int i = 0; i < lapsList.size(); i++) {

					Active active = lapsList.get(i);

					LocalDateTime incTime = null;

					if (i == 0) {
						tmp = active.getLapCount();
						incTime = DateUtils.dateToLocalDateTime(active.getInsertDateTime());
						continue;
					}

					int incLap = active.getLapCount() - tmp;

					if (i != lapsList.size() - 1) {
						incTime = DateUtils.dateToLocalDateTime(active.getInsertDateTime());
						tmp = active.getLapCount();
						xAisData.add(incTime.format(DateTimeFormatter.ofPattern("HH:mm")));
						seriesData.add(incLap);
					}
				}

				// echart对象
				EchartObject result = new EchartObject();
				result.setXAxis(xAisData);
				result.setSeries(seriesData);

				// redisへ保存する
				redisTemplate.opsForHash().put("daylyIncrement_" + hamster.getHamsterId().toString(),
						dateNow.toString(), JSON.toJSONString(result));
				// 删除6天前的缓存
				redisTemplate.opsForHash().delete("daylyIncrement_" + hamster.getHamsterId().toString(),
						dateNow.minusDays(6).toString());
			}

		});
	}
}
