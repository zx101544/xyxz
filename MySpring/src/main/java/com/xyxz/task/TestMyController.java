package com.xyxz.task;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asyn")
public class TestMyController {
	@Autowired
	Test test;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/do")
	public String doS() throws Exception{
		long start=System.currentTimeMillis();
		Future<Boolean> f1=test.doTask1();
		Future<Boolean> f2=test.doTask2();
		Future<Boolean> f3=test.doTask3();
		while(!f1.isDone()||!f2.isDone()||!f3.isDone()) {
			if(f1.isDone()&&f2.isDone()&&f3.isDone()) {
				break;
			}
		}
		long end=System.currentTimeMillis();
		logger.info("耗时："+(end-start+"毫秒"));
		return null;
	}
}
