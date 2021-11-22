package com.foat.secrettransfer.dto;

public class SecretMessage {

	private String message;

	public SecretMessage() {
	}

	public SecretMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
