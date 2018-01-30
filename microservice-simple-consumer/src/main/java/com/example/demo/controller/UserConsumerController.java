package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.User;

@RestController
public class UserConsumerController {

  @Autowired
  private RestTemplate restTemplate;
  
  @GetMapping("/consumer/{id}")
  public User findById(@PathVariable("id") Long id) {
    return this.restTemplate.getForObject("http://SIMPLE-PROVIDER/provider/"+id, User.class);
  }
}
