package com.vincent.demo.web.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {
	
	@RequestMapping("/test1")
	public String test1() {
		System.out.println("我是controller");
		return null;
	}
}
