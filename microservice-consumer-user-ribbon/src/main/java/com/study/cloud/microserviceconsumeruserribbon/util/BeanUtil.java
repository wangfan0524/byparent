package com.study.cloud.microserviceconsumeruserribbon.util;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanUtil {

    @Bean
    //此注解就代表消费端已经集成了ribbon，使RestTemplate具备了客户端负载均衡的能力
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
