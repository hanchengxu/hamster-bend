package com.example.hamster.batch;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.hamster.entity.Active;
import com.example.hamster.mapper.ActiveMapper;

@Component
public class SaveLapToDB {

	private static final Logger logger = LoggerFactory.getLogger(SaveLapToDB.class);

	@Autowired
	ActiveMapper activeMapper;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 *  这是配合redis持久化跑圈数据的batch.
	 *  每两分钟获取redis 和db 数据状态，判断是否需要持久化到DB
	 *  
	 */
	@Scheduled(fixedRate = 1000 * 60 * 2)
	@Async
	public void saveLapCountToDB() {
		// 首先获取所有hamster 最大圈数
		List<Map<String, Object>> list = activeMapper.selectAllMaxLapCount();

		/**
		 * 对比db和redis中圈数
		 * 0. db存在redis不存在，更新到redis中 
		 * 1. db>redis: 有可能是redis宕机，且dump.rdb丢失。则需要从db加载数据 
		 * 2. db=redis:不需要同步的数据 
		 * 3. db<redis: 跑圈数增加，需要持久化到DB
		 */
		list.stream().forEach((map) -> {

			Integer hamsterId = (Integer) map.get("hamster_id");
			Integer maxLapCount = (Integer) map.get("max_lap");
			Integer maxLapCountRedis = (Integer) redisTemplate.opsForValue().get(hamsterId.toString());
			
			logger.debug("hamsterId:"+hamsterId+",max_lap:"+maxLapCount+",maxLapCountRedis:"+maxLapCountRedis );
			
			if (null == maxLapCountRedis) {
				// db存在 redis缓存不存在，则将db值更新到缓存中
				redisTemplate.opsForValue().increment(hamsterId.toString(), maxLapCount);
			} else {
				if (maxLapCount > maxLapCountRedis) {
					redisTemplate.opsForValue().set(hamsterId.toString(), maxLapCount);
				} else if (maxLapCount < maxLapCountRedis) {
					// 记录跑圈数据
					Active active = new Active();
					active.setHamsterId(hamsterId);
					active.setLapCount(maxLapCountRedis);
					active.setInsertDateTime(new Date());
					active.setInsertUser("system");
					activeMapper.insertSelective(active);
				}
			}
		});

		
	}
	
}
