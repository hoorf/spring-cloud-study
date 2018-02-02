package com.example.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@FeignClient(name = "SIMPLE-PROVIDER", configuration = UserFeignClientConfig.class, /**fallback = UserFeignClientFallback.class,**/ fallbackFactory = UserClientfallbackFactory.class)
public interface UserFeignClient {

	@GetMapping("/provider/{id}")
	@HystrixCommand(fallbackMethod = "findUserByIdFallback")
	public User findUserById(@PathVariable("id") Long id);
}
