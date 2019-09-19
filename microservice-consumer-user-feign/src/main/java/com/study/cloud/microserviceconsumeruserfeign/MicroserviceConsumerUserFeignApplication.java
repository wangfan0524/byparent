package com.study.cloud.microserviceconsumeruserfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
//这里即使指定了配置，依然会采用默认的轮询，所以务必保证configuration = LoadBalanceConfig.class
//所在的类不在主上下文中，否则即使配置了其他规则也无效
@EnableFeignClients
@EnableCircuitBreaker
@EnableSwagger2
public class MicroserviceConsumerUserFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerUserFeignApplication.class, args);
    }

}
