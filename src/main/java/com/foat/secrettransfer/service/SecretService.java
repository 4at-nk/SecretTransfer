package com.foat.secrettransfer.service;

import com.foat.secrettransfer.model.Secret;
import com.foat.secrettransfer.repo.SecretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class SecretService {
	
	@Autowired
	private SecretRepository repository;
	
	public String saveSecret(String message) {
		String secretId = UUID.randomUUID().toString();
		
		Secret secret = new Secret();
		secret.setSecretId(secretId);
		secret.setValue(message);
		secret.setCreatedDate(LocalDateTime.now());
		
		repository.save(secret);
		
		return secretId;
	}
	
	public Optional<String> getSecret(String secretId) {
		return Optional.ofNullable(repository.findBySecretId(secretId))
				.map(Secret::getValue);
	}
	
	@Transactional
	public void deleteSecretsCreatedBeforeDate(LocalDateTime date) {
		repository.deleteByCreatedDateBefore(date);
	}
}
