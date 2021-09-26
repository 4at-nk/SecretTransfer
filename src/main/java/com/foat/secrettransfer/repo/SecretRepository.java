package com.foat.secrettransfer.repo;

import com.foat.secrettransfer.model.Secret;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretRepository extends CrudRepository<Secret, Long> {
	
	Secret getSecretBySecretId(String secretId);
}
