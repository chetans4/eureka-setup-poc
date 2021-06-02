package com.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-eureka-client-one")
public interface GreetingClient {

	@RequestMapping("/greeting")
    String greeting();
	
}
