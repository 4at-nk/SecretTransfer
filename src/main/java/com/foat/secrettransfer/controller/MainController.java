package com.foat.secrettransfer.controller;

import com.foat.secrettransfer.dto.SecretId;
import com.foat.secrettransfer.dto.SecretMessage;
import com.foat.secrettransfer.service.SecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
	
	@GetMapping(value = "/{secretId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SecretMessage getSecret(@PathVariable("secretId") String secretId) {
		return service.getSecret(secretId)
				.map(SecretMessage::new)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public SecretId saveSecret(@RequestBody String message) {
		return new SecretId(service.saveSecret(message));
	}
}
