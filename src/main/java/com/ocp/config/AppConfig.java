package com.ocp.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableScheduling
@ComponentScan
@Configuration
public class AppConfig {
	
	@Bean
	public TaskExecutor taskExecutor (){
		ThreadPoolTaskExecutor tx = new ThreadPoolTaskExecutor () ;
		tx.setCorePoolSize(5);
		tx.setMaxPoolSize(10);
		tx.setQueueCapacity(25);
		return  tx ; 
	} 	
}
