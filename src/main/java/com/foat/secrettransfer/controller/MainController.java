package com.foat.secrettransfer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/getsecret")
	public String getSecret() {
		return "Some secret phrase";
	}
	
	@PostMapping("/savesecret")
	public String saveSecret() {
		return "url of some secret";
	}
}
