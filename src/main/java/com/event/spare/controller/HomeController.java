package com.event.spare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"", "/", "/index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = {"/signin", "/signup"})
	public String signIn() {
		return "sign-in";
	}
	
	@RequestMapping("/fun-run")
	public String funRun() {
		return "fun-run";
	}
	
	@RequestMapping("/festival")
	public String festival() {
		return "festival";
	}
	
	@RequestMapping("/about-us")
	public String aboutUs() {
		return "about-us";
	}
	
	@RequestMapping("/event/register/asd")
	public String coba() {
		return "about-us";
	}
}
