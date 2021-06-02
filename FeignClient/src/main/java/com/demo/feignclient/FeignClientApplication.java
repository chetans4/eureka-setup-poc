package com.demo.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import feign.FeignException.ServiceUnavailable;

@SpringBootApplication
@EnableFeignClients
@Controller
public class FeignClientApplication {

	@Autowired
    private GreetingClient greetingClient;
	
	@Autowired
	private SecondClient secondClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignClientApplication.class, args);
    }

    @RequestMapping("/get-greeting")
    public String greeting(Model model) {
        try {
			model.addAttribute("greeting", greetingClient.greeting());
		} catch (ServiceUnavailable e) {
			model.addAttribute("greeting", e.getMessage());
		}
        return "greeting-view";
    }
    
    @RequestMapping("/get-second")
    public String second(Model model) {
        model.addAttribute("greeting", secondClient.second());
        return "greeting-view";
    }

}
