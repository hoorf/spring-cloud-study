package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class MicroserviceSimpleConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleConsumerApplication.class, args);
	}
}
