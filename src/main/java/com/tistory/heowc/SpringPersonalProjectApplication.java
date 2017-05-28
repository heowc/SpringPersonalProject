package com.tistory.heowc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringPersonalProjectApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringPersonalProjectApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(SpringPersonalProjectApplication.class, args);
		ac.getBeanFactory().getBeanNamesIterator().forEachRemaining(logger::info);
	}
}
