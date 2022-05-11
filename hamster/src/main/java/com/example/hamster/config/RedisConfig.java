package com.example.hamster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		// key序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		// value序列化
		redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
		// Hash key序列化
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		// Hash value序列化
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		
		redisTemplate.setConnectionFactory(factory);
		
		return redisTemplate;
	}
}
