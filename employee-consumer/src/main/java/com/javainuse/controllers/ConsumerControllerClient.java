package com.javainuse.controllers;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;




@RestController("/api/v1/consumers")
public class ConsumerControllerClient {
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@GetMapping
	public List<com.javainuse.dto.Employee> getAll(){
		
		ServiceInstance serviceInstance=loadBalancer.choose("MYBANK1");
				
		String uri=serviceInstance.getUri().toString();
		
		System.out.println(uri+"  is working");
	
		RestTemplate rest=new RestTemplate();
		List<com.javainuse.dto.Employee> ll1= rest.getForObject(uri+"/api/v1/employees", List.class);
		
		return ll1;
	}

	
}