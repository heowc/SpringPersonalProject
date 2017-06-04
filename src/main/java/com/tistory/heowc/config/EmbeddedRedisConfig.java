package com.tistory.heowc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Protocol;
import redis.embedded.RedisServer;

@Configuration
public class EmbeddedRedisConfig {

    @Bean
    public RedisServer redisServer() {
        RedisServer.builder().reset();

        return RedisServer.builder().port(Protocol.DEFAULT_PORT).build();
    }
}
