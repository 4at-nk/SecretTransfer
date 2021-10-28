package com.foat.secrettransfer.job;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob()
				.ofType(ExpirationDeleteJob.class)
				.storeDurably()
				.withIdentity("expiration_job_detail")
				.withDescription("Deletes old expired secrets")
				.build();
	}

	@Bean
	public Trigger trigger(JobDetail job) {
		return TriggerBuilder.newTrigger()
				.forJob(job)
				.withIdentity("expiration_job_trigger")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule()
						.repeatForever()
						.withIntervalInHours(1))
				.build();
	}
}
