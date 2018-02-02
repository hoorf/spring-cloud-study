package com.example.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class UserClientfallbackFactory implements FallbackFactory<UserFeignClient> {

	Logger log = LoggerFactory.getLogger(UserClientfallbackFactory.class);

	@Override
	public UserFeignClient create(Throwable cause) {
		return new UserFeignClient() {

			@Override
			public User findUserById(Long id) {
				log.info("fall back cause :{}", cause.getMessage());
				User u = new User();
				u.setId(-2L);
				u.setName("fallbackFactory");
				return u;
			}

		};

	}

}
