package com.study.cloud.microserviceconsumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//集称了服务发现的注解，所以不用添加@EnableEurekaClient等类似的注解
@EnableZuulProxy
@EnableEurekaClient
public class MicroserviceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceZuulApplication.class, args);
    }

}
