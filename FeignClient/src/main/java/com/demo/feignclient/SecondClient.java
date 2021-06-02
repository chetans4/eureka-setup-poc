package com.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-eureka-client-two")
public interface SecondClient {

	@RequestMapping("/second")
    String second();
	
}
