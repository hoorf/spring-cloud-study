package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import com.example.demo.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@SessionScope
public class UserConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/consumer/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
	public User findById(@PathVariable("id") Long id) {
		return this.restTemplate.getForObject("http://SIMPLE-PROVIDER/provider/" + id, User.class);
	}

	public User findByIdFallback(Long id) {
		User u = new User();
		u.setId(-1L);
		return u;
	}
}
