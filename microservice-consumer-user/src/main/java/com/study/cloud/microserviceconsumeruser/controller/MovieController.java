package com.study.cloud.microserviceconsumeruser.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.study.cloud.microserviceconsumeruser.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {
@Autowired
private RestTemplate restTemplate;


    @GetMapping("/movie/get/{id}")
    public Object getMovie(@PathVariable Long id){
       Object object= restTemplate.getForObject("http://localhost:7900/simple/1",Object.class);
       return object;
    }

    @GetMapping("/movie/test/{id}")
    public User testRest(@PathVariable Long id){

        User user=new User();
        user.setId(1L);
        user.setName("王");
        user.setAge((short) 25);
        List<User> users=new ArrayList<>();
        users.add(user);
        List<String> usernames=users.stream().map(User::getName).collect(Collectors.toList());
        user=restTemplate.postForObject("http://127.0.0.1:7905/testPost1",usernames,User.class);
        //Object object= restTemplate.getForObject("http://localhost:7900/simple/1",Object.class);
        return user;
    }
}
