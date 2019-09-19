package com.study.cloud.microserviceconsumeruserribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieRibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/get/{id}")
    public Object getMovie(@PathVariable Long id) throws Exception {
        //使用VIP vitrual IP(服务提供者的serviceID 或者spring.application.name)
        Object object = null;
        object = restTemplate.getForObject("http://microservice-provider-user/simple/1", Object.class);
        System.out.println(object);
        return object;
    }

}
