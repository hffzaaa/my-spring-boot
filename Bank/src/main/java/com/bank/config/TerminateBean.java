package com.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class TerminateBean {

	private static final Logger logger = LoggerFactory.getLogger(TerminateBean.class);
	
    @PreDestroy
    public void onDestroy() {
    	logger.info("Spring Container is destroyed!");
    }
    
    @Bean
    public TerminateBean getTerminateBean() {
        return new TerminateBean();
    }
}
