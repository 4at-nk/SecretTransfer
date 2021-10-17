package com.foat.secrettransfer.controller;

import com.foat.secrettransfer.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/secret")
public class MainController {
	
	@Autowired
	private SecretService service;
	
	@GetMapping("/{secretId}")
	public String getSecret(@PathVariable("secretId") String secretId) {
		return service.getSecret(secretId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveSecret(@RequestBody String message) {
		return service.saveSecret(message);
	}
}
