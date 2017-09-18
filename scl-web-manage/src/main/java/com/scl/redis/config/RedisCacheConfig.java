//package com.scl.redis.config;
//
//import java.lang.reflect.Method;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.session.FindByIndexNameSessionRepository;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// * 
// * ClassName: RedisCacheConfig<br/>
// * Function: TODO ADD CLASS.<br/>
// * Date: 2017年2月15日 上午10:22:28<br/>
// * 
// * @author shengchenglong
// * @version
// * @since JDK 1.8
// *
// */
//@EnableCaching
//@Configuration
//public class RedisCacheConfig extends CachingConfigurerSupport {
//
//	private Logger logger = LoggerFactory.getLogger(RedisCacheConfig.class);
//
//	/**
//	 * 声明 自定义缓存数据 key 生成策略
//	 * 
//	 * @return
//	 */
//	@Bean(name = "myKeyGenerator")
//	public KeyGenerator myKeyGenerator() {
//		return new KeyGenerator() {
//			/*
//			 * 对于使用注解缓存结果的方法，生成key，key值为：类名＋方法名＋参数名
//			 * 
//			 * @see
//			 * org.springframework.cache.interceptor.KeyGenerator#generate(java.
//			 * lang.Object, java.lang.reflect.Method, java.lang.Object[])
//			 */
//			@Override
//			public Object generate(Object target, Method method, Object... params) {
//				StringBuilder sb = new StringBuilder();
//				sb.append(target.getClass().getName());
//				sb.append("." + method.getName());
//				for (Object obj : params) {
//					sb.append(obj.toString());
//				}
//				return sb.toString();
//			}
//		};
//	}
//
//	/**
//	 * 这里的RedisConnectionFactory是spirngboot自动配置的可以直接注入 在这里自定义RedisTemplate
//	 * 
//	 * @param factory
//	 * @return
//	 */
//	@Bean
//	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//		
//		StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
//		@SuppressWarnings("rawtypes")
//		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//		ObjectMapper om = new ObjectMapper();
//		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//		jackson2JsonRedisSerializer.setObjectMapper(om);
//		template.setValueSerializer(jackson2JsonRedisSerializer);
//		template.afterPropertiesSet();
//		return template;
//	}
//
//	/**
//	 * 针对不同的缓存技术，需要实现不同的CacheManager
//	 * 
//	 * @param redisTemplate
//	 * @return
//	 */
//	@Bean(name = "redisCacheManager")
//	public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
//		return new RedisCacheManager(redisTemplate);
//	}
//
//}
