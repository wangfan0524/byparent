package com.study.cloud.microserviceconsumeruser.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanUtil {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
