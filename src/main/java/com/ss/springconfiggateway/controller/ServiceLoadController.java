package com.ss.springconfiggateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ServiceLoadController {
	
	@Autowired
	LoadBalancerClientFactory clientFactory;
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@CircuitBreaker(name="backup", fallbackMethod="fallbackGetOrders")
	@GetMapping("/busroutes")
	public String getBusRoutes() {
		
		
		RoundRobinLoadBalancer lb = clientFactory.getInstance("",RoundRobinLoadBalancer.class);
		ServiceInstance instance =lb.choose().block().getServer();
		
		return restTemplate.getForObject("http://" +instance.getHost()+ ":" +instance.getPort()+ "/busroutes", String.class);
		
	}
	
	@CircuitBreaker(name="backup", fallbackMethod="fallbackGetOrders")
	@GetMapping("/payment")
	public String getPayment() {
		
		
		RoundRobinLoadBalancer lb = clientFactory.getInstance("",RoundRobinLoadBalancer.class);
		ServiceInstance instance =lb.choose().block().getServer();
		
		return restTemplate.getForObject("http://" +instance.getHost()+ ":" +instance.getPort()+ "/busroutes", String.class);
		
	}
	
	@CircuitBreaker(name="backup", fallbackMethod="fallbackGetOrders")
	@GetMapping("/inventory")
	public String getInventory() {
		
		
		RoundRobinLoadBalancer lb = clientFactory.getInstance("",RoundRobinLoadBalancer.class);
		ServiceInstance instance =lb.choose().block().getServer();
		
		return restTemplate.getForObject("http://" +instance.getHost()+ ":" +instance.getPort()+ "/busroutes", String.class);
		
	}
	
	@CircuitBreaker(name="backup", fallbackMethod="fallbackGetOrders")
	@GetMapping("/booking")
	public String getBooking() {
		
		
		RoundRobinLoadBalancer lb = clientFactory.getInstance("",RoundRobinLoadBalancer.class);
		ServiceInstance instance =lb.choose().block().getServer();
		
		return restTemplate.getForObject("http://" +instance.getHost()+ ":" +instance.getPort()+ "/busroutes", String.class);
		
	}

}
