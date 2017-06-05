package com.tistory.heowc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import redis.embedded.RedisServer;

@Slf4j
@SpringBootApplication
public class SpringPersonalProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(SpringPersonalProjectApplication.class, args);
		ac.getBeanFactory().getBeanNamesIterator().forEachRemaining(log::info);
	}
}
