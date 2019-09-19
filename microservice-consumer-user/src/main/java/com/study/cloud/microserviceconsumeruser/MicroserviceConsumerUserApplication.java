package com.study.cloud.microserviceconsumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerUserApplication.class, args);
	}

}
