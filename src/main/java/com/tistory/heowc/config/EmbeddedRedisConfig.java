package com.tistory.heowc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class EmbeddedRedisConfig {

    @Bean
    public RedisServer redisServer() {
        RedisServer.builder().reset();
        return RedisServer.builder().port(Protocol.DEFAULT_PORT).build();
    }

    @PostConstruct
    public void start() {
        if (!redisServer().isActive()) redisServer().start();
    }

    @PreDestroy
    public void stop() {
        redisServer().stop();
    }
}