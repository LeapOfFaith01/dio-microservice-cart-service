package com.challenges.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Service;

@Configuration
@EnableRedisRepositories
public class RedisConfig{
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }

    @Bean
    RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return stringRedisTemplate;
    }
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory(){
//        var jedisConFactory = new JedisConnectionFactory();
//        jedisConFactory.setHostName("localhost");
//        jedisConFactory.setPort(6379);
//        jedisConFactory.getPoolConfig().setMaxIdle(30);
//        jedisConFactory.getPoolConfig().setMinIdle(10);
//        return jedisConFactory;
//    }
//
//    @Bean(name="redisTemplate")
//    public RedisTemplate<String, Object> redisTemplate(){
//        RedisTemplate<String,Object> template = new RedisTemplate<>();
//
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
}
