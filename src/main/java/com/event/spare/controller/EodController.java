package com.event.spare.controller;

import java.security.Principal;

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
	
	@RequestMapping("/events")
	public String events() {
		return "eod-events";
	}
	
	@RequestMapping("/articles")
	public String articles() {
		return "eod-articles";
	}
	
	@RequestMapping("/articles/add")
	public String articlesAdd() {
		return "eod-articles-add";
	}
	
	@RequestMapping("/payments")
	public String payments() {
		return "eod-payments";
	}
	
	@RequestMapping("/attendance")
	public String attendance() {
		return "eod-attendance";
	}
	
	@RequestMapping("/publication")
	public String publication() {
		return "eod-publication";
	}
	
	@RequestMapping("/signin")
	public String signin(Principal principal) {
		if(principal != null) {
    		return "redirect:/eod";
    	}
		
		return "eod-sign-in";
	}
	
}
