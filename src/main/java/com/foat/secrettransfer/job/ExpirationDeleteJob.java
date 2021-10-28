package com.foat.secrettransfer.job;

import com.foat.secrettransfer.service.SecretService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class ExpirationDeleteJob implements Job {
	
	private static final Logger log = LoggerFactory.getLogger(ExpirationDeleteJob.class);
	
	@Autowired
	private SecretService service;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		LocalDateTime expirationDate = LocalDateTime.now()
				.minusDays(7);
		log.info("Removing of expired secrets - secrets created before {} will be removed",
				expirationDate.truncatedTo(ChronoUnit.SECONDS));
		service.deleteSecretsCreatedBeforeDate(expirationDate);
	}
}
