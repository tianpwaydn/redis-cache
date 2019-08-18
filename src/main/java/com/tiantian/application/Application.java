package com.tiantian.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.PostConstruct;

@EnableCaching
@SpringBootApplication
@ComponentScan("com.tiantian")
@MapperScan("com.tiantian.mapper")
public class Application {
    @Autowired
    private RedisTemplate redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    public void initRedisTemplate(){
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();

        redisTemplate.setKeySerializer(stringSerializer);

        redisTemplate.setHashKeySerializer(stringSerializer);
    }

}
