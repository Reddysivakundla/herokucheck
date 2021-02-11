package com.sharethought.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	@GetMapping("/")
	public String checkUrl() {
		return "Reddy Siva Kundla";
	}
}
