package com.example.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.User;

@FeignClient(name = "SIMPLE-PROVIDER", fallback = HystrixFallBackClient.class)
public interface UserFeignClient {

	@GetMapping("/provider/{id}")
	public User findUserById(@PathVariable("id") Long id);
}
