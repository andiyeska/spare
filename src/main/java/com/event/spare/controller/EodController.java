package com.event.spare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eod")
public class EodController {

	@RequestMapping(value = {"", "/", "/index"})
	public String index() {
		return "eod-index";
	}
	
	@RequestMapping("/users")
	public String users() {
		return "eod-users";
	}
	
}
