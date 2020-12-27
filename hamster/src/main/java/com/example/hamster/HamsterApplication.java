package com.example.hamster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class HamsterApplication {
	@RequestMapping("/")
    String home() {
        return "Hello World! wangxue";
    }

	public static void main(String[] args) {
		SpringApplication.run(HamsterApplication.class, args);
	}

}
