package com.example.spring.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {
	private final Logger logger=LoggerFactory.getLogger(ScheduleTasks.class);
	private SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate=5000)
	public void reportCurrentTime() {
		logger.info("The current time is {}",format.format(new Date()));
	}
}
