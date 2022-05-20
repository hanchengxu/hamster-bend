package com.example.hamster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan({"com.example.hamster.mapper"})
@EnableScheduling
@EnableAsync
public class HamsterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HamsterApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(HamsterApplication.class);
    }
    
}
