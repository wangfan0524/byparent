package com.study.cloud.microserviceprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaServer只针对Eureka可用，也可以使用@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
public class MicroserviceProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProviderUserApplication.class, args);
	}

}
