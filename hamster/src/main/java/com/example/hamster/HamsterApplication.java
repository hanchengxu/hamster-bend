package com.example.hamster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan({"com.example.hamster.mapper"})
public class HamsterApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(HamsterApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        //找到原先的启动类
        return application.sources(HamsterApplication.class);
    }
}
