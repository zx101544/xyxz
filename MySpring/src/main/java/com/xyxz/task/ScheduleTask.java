package com.xyxz.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    private Logger logger=LoggerFactory.getLogger(this.getClass());
	private final static SimpleDateFormat format=new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
	@Scheduled(fixedRate=3000)
	public void schedule() {
		logger.info("目前的时间: "+format.format(new Date()));
	}
}
