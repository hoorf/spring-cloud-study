package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.Logger;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroserviceFeignApplication {

	@Bean
	public Logger.Level feignLoggerLevel() {
		return feign.Logger.Level.FULL;
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceFeignApplication.class, args);
	}
}
