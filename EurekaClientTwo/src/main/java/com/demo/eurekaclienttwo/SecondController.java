package com.demo.eurekaclienttwo;

import org.springframework.web.bind.annotation.RequestMapping;

public interface SecondController {

	@RequestMapping("/second")
    String second();
	
}
