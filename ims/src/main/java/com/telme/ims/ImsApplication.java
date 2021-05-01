package com.telme.ims;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ImsApplication {
	static Logger log = LoggerFactory.getLogger(ImsApplication.class);
	
	public static void main(String[] args) {
		log.debug("ImsApplication() - Start up");
		SpringApplication.run(ImsApplication.class, args);
		
	}
	
	
	
	
}
