package com.example.demo.client;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class UserFeignClientFallback implements UserFeignClient {

	@Override
	public User findUserById(Long id) {
		User user = new User();
		user.setName("已经 fallback 了");
		return user;
	}

}
