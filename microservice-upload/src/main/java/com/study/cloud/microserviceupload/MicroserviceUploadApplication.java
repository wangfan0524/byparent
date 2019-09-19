package com.study.cloud.microserviceupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//集称了服务发现的注解，所以不用添加@EnableEurekaClient等类似的注解
@EnableEurekaClient
public class MicroserviceUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUploadApplication.class, args);
    }

}
