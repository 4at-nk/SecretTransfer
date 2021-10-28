package com.foat.secrettransfer.repo;

import com.foat.secrettransfer.model.Secret;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SecretRepository extends CrudRepository<Secret, Long> {
	
	Secret findBySecretId(String secretId);
	
	void deleteByCreatedDateBefore(LocalDateTime date);
}
