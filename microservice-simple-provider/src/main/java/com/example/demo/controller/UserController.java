package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/provider/{id}")
	public User findUserById(@PathVariable("id") Long id) {
		return userRepository.getOne(id);
	}

	@GetMapping("/eureka-instance")
	public String serviceUrl() {
		InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("SIMPLE-PROVIDER", false);
		return instance.getHomePageUrl();

	}

}
