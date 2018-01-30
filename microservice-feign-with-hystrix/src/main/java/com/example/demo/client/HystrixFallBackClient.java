package com.example.demo.client;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class HystrixFallBackClient implements UserFeignClient {

	@Override
	public User findUserById(Long id) {
		User user = new User();
		user.setId(0L);
		return user;
	}

}
