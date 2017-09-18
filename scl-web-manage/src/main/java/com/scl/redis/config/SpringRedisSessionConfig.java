//package com.scl.redis.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//@Configuration
//@EnableRedisHttpSession
//public class SpringRedisSessionConfig {
//	
////	@Bean
////	public RedisHttpSessionConfiguration redisHttpSessionConfiguration() {
////		RedisHttpSessionConfiguration configuration = new RedisHttpSessionConfiguration();
////		return configuration;
////	}
//	
////	@Bean
////	public LettuceConnectionFactory lettuceConnectionFactory() {
////		return new LettuceConnectionFactory();
////	}
//	
////	@Bean 
////	public RedisConnectionFactory redisConnectionFactory() {
////		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
////		return connectionFactory;
////	}
////	
//
//}