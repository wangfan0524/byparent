package com.study.cloud.microserviceswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

//这里即使指定了配置，依然会采用默认的轮询，所以务必保证configuration = LoadBalanceConfig.class
//所在的类不在主上下文中，否则即使配置了其他规则也无效
@EnableEurekaClient
public class MicroserviceSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSwaggerApplication.class, args);
    }

}
