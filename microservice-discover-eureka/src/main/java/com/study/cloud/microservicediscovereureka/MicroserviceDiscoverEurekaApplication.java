package com.study.cloud.microservicediscovereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//注释本服务作为一个注册中心
@EnableEurekaServer
public class MicroserviceDiscoverEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDiscoverEurekaApplication.class, args);
	}

}
