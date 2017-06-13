package com.tistory.heowc.config;

import com.tistory.heowc.domain.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class EmbeddedRedisConfig {

//    @Bean
//    public RedisServer redisServer() {
//        RedisServer.builder().reset();
//        return RedisServer.builder().port(Protocol.DEFAULT_PORT).build();
//    }

    @Bean("memberRedisTemplate")
    public RedisTemplate<String, Member> memberRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Member> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Member.class));
        redisTemplate.setEnableTransactionSupport(true);
        return redisTemplate;
    }

//    @PostConstruct
//    public void start() {
//        if (!redisServer().isActive()) redisServer().start();
//    }
//
//    @PreDestroy
//    public void stop() {
//        redisServer().stop();
//    }
}