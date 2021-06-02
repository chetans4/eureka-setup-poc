package com.demo.eurekaclient;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {

	@RequestMapping("/greeting")
    String greeting();
	
}
