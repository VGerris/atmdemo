package com.example.simpleatm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "index";
	}

	@RequestMapping("/home2")
	public String home2() {
		return "index2";
	}
}
