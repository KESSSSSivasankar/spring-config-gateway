package com.ss.springconfiggateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringConfigGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigGatewayApplication.class, args);
	}

}
