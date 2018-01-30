package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.UserFeignClient;
import com.example.demo.entity.User;

@RestController
public class UserConsumerController {

	@Autowired
	private UserFeignClient client;

	@GetMapping("/consumer/{id}")
	public User findById(@PathVariable("id") Long id) {
		return client.findUserById(id);
	}
}
