package com.xyxz.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/asyn/**");
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/asyn/**");
		
	}

}
