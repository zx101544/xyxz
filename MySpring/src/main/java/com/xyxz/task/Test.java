package com.xyxz.task;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class Test {
     private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Async
	public Future<Boolean> doTask1() throws Exception {
		long start=System.currentTimeMillis();
		Thread.sleep(1000);
		long end=System.currentTimeMillis();
		logger.info("任务一耗时："+(end-start)+"毫秒");
		return new AsyncResult<>(true);
	}
	@Async
	public  Future<Boolean> doTask2() throws Exception {
		long start=System.currentTimeMillis();
		Thread.sleep(700);
		long end=System.currentTimeMillis();
		logger.info("任务二耗时："+(end-start)+"毫秒");
		return new AsyncResult<>(true);
	}
	@Async
	public  Future<Boolean> doTask3() throws Exception {
		long start=System.currentTimeMillis();
		Thread.sleep(600);
		long end=System.currentTimeMillis();
		logger.info("任务三耗时："+(end-start)+"毫秒");
		return new AsyncResult<>(true);
	}
}
