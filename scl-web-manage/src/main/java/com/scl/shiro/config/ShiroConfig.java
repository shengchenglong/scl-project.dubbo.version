package com.scl.shiro.config;

import java.util.*;

import javax.servlet.Filter;

import com.scl.shiro.properties.RedisConfigProperties;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.scl.shiro.realm.UserRealm;

/**
 * Shiro configuration
 *
 * @author shengchenglong
 *
 */
@Configuration
public class ShiroConfig {

	private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	/**
	 * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
	 * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
	 * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
	 */
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * HashedCredentialsMatcher，这个类是为了对密码进行编码的，防止密码在数据库里明码保存，
	 * 当然在登陆认证的生活，这个类也负责对form里输入的密码进行编码
	 *
	 * @return
	 */
	@Bean(name = "hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		// 设置散列算法
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		// 设置散列次数
		hashedCredentialsMatcher.setHashIterations(2);
		// 设置密码是由什么方式保存的（该处不给值 默认base64）
		hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
		return hashedCredentialsMatcher;
	}

	/**
	 * 实例化UserRealm，设置匹配验证器
	 *
	 * @return
	 */
	@Bean(name = "userRealm")
	public UserRealm userRealm() {
		UserRealm realm = new UserRealm();
		realm.setCredentialsMatcher(hashedCredentialsMatcher());
		return realm;
	}

	/**
	 * EhCacheManager，缓存管理，用户登陆成功后，把用户信息和权限信息缓存起来，
	 * 然后每次用户请求时，放入用户的session中，如果不设置这个bean，每个请求都会查询一次数据库。
	 */
//	@Bean(name = "cacheManager")
//	public EhCacheManager ehCacheManager() {
//		EhCacheManager em = new EhCacheManager();
//		em.setCacheManagerConfigFile("classpath:cache/ehcache-shiro.xml");
//		return em;
//	}

	/**
	 * ShiroFilterFactoryBean，是个factorybean，为了生成ShiroFilter。
	 * 它主要保持了三项数据，securityManager，filters，filterChainDefinitionManager。
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		// 必须设置SecirityManage
		bean.setSecurityManager(securityManager);

		Map<String, Filter> filters = new LinkedHashMap<String, Filter>();
		// 登出过滤器
		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/manage/login");
		filters.put("logoutFilter", logoutFilter);
		// 登陆过滤器
		FormAuthenticationFilter authenticationFilter = new FormAuthenticationFilter();
		authenticationFilter.setUsernameParam("username");
		authenticationFilter.setPasswordParam("password");
		// authenticationFilter.setRememberMeParam("rememberMe");
		authenticationFilter.setLoginUrl("/manage/login");
		authenticationFilter.setFailureKeyAttribute("shiroLoginFailure"); // 实际上默认就是这个名字
		filters.put("loginFilter", authenticationFilter);
		// 当前用户过滤器
		// CurrentUserFilter currentUserFilter = new CurrentUserFilter();
		// filters.put("currentUserFilter", currentUserFilter);

		bean.setFilters(filters);

		logger.info("##################从数据库读取权限规则，加载到shiroFilter中##################");
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		// 要先添加anon不需要权限的路径， 否则会不生效
		// filterChainDefinitionMap.put("/manage/**/to*", "anon");
		// filterChainDefinitionMap.put("/manage/**/do*", "anon");
		// filterChainDefinitionMap.put("/manage/**/check*", "anon");

		// 在添加其他需要权限的路径
		filterChainDefinitionMap.put("/manage/logout", "logoutFilter");
		filterChainDefinitionMap.put("/manage/login", "loginFilter");
		// filterChainDefinitionMap.put("/manage/**", "user, currentUserFilter");
		filterChainDefinitionMap.put("/manage/**", "user");

		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		bean.setLoginUrl("/manage/login");
		// 登录成功之后的跳转
		bean.setSuccessUrl("/manage/index");
		// 没有权限的跳转
		bean.setUnauthorizedUrl("");

		return bean;
	}

	/**
	 * 会话管理器
	 * DefaultWebSessionManager用于 Web 环境的实现,可以替代 ServletContainerSessionManager,自己维护着会话,直接废弃了 Servlet容器的会话管理。
	 * 默认情况下 globalSessionTimeout 将应用给所有 Session。可以单独设置每个 Session的timeout 属性来为每个 Session 设置其超时时间。
	 * 另外如果使用 ServletContainerSessionManager进行会话管理,Session 的超时依赖于底层 Servlet 容器的超时时间,可以在 web.xml中配置其会话的超时时间(分钟为单位):
	 * <session-config>
	 * 	<session-timeout>30</session-timeout>
	 * </session-config>在 Servlet
	 * 容器中,默认使用 JSESSIONID Cookie 维护会话,且会话默认是跟容器绑定的;
	 * 在某些情况下可能需要使用自己的会话机制,此时我们可以使用 DefaultWebSessionManager 来维护会话:
	 *
	 * @return
	 */
	@Bean(name = "defaultWebSessionManager")
	public DefaultWebSessionManager defaultWebSessionManager(RedisSessionDAO redisSessionDAO) {
		DefaultWebSessionManager sessionManage = new DefaultWebSessionManager();
		sessionManage.setGlobalSessionTimeout(1800000);
		// 设置cookie模板
		sessionManage.setSessionIdCookie(simpleCookie());
		// 是否启用/禁用 Session Id Cookie,默认是启用的; 如果禁用后将不会设置 Session Id Cookie,即默认使用了 Servlet 容器的 JSESSIONID
		// 且通 过 URL 重写(URL 中的“;JSESSIONID=id”部分)保存 Session Id。
		sessionManage.setSessionIdCookieEnabled(true);
		//	会话 监听器添加
		List<SessionListener> listeners = new ArrayList<SessionListener>();
//		listeners.add(mySessionListener());
		sessionManage.setSessionListeners(listeners); // 添加会话监听器
		//	添加sessionDAO
		sessionManage.setSessionDAO(redisSessionDAO);
		// 禁用url重写会话
		sessionManage.setSessionIdUrlRewritingEnabled(false);
		return sessionManage;
	}

	@Bean
	public RedisConfigProperties redisConfigModel() {
		return new RedisConfigProperties();
	}

	// 配置redis－shiro 开始
	@Bean
	@ConfigurationProperties(prefix = "redis.config")
	public RedisManager redisManager(RedisConfigProperties model) {
		RedisManager redisManager = new RedisManager();
		// 设置redis中session的过期时间，从最后一次请求算起，秒为单位，
		// 过期后删除redis中的session, 0代表不删除
		redisManager.setExpire(model.getExpire());
		redisManager.setHost(model.getHost());
		redisManager.setPassword(model.getPassword());
		redisManager.setPort(model.getPort());
		// optional, timeout for jedis try to connect to redis server(In milliseconds), not equals to expire time!
		redisManager.setTimeout(0);
		return redisManager;
	}

	@Bean
	public RedisSessionDAO redisSessionDAO(RedisManager redisManager) {
		RedisSessionDAO dao = new RedisSessionDAO();
		dao.setRedisManager(redisManager);
		return dao;
	}

	@Bean
	public RedisCacheManager redisCacheManager(RedisManager redisManager) {
		RedisCacheManager redisCacheManager = new RedisCacheManager();
		redisCacheManager.setKeyPrefix("users:security:user:");
		redisCacheManager.setRedisManager(redisManager);
		return redisCacheManager;
	}
	// 配置redis－shiro 结束

//	/**
//	 * 会话监听器，继承SessionListenerAdapter
//	 * @return
//	 */
//	public SessionListener mySessionListener() {
//		SessionListener sessionListener = new MySessionListener();
//		return sessionListener;
//	}

	/**
	 * cookie 模板
	 * @return
	 */
	@Bean(name = "simpleCookie")
	public SimpleCookie simpleCookie() {
		SimpleCookie cookie = new SimpleCookie();
		cookie.setName("JSESSIONID"); // 默认即为该值
		//cookie.setDomain(""); // 设置 Cookie 的域名,默认空,即当前访问的域名;
		//cookie.setPath(""); //设置 Cookie 的路径,默认空,即存储在域名根下;
		cookie.setMaxAge(180); //设置 Cookie 的过期时间,秒为单位,默认-1 表示关闭浏览器时Cookie过期;
		cookie.setHttpOnly(true);//如果设置为 true,则客户端不会暴露给客户端脚本代码
		return cookie;
	}

	/**
	 * SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理， 是个比较重要的类。
	 *
	 * @return
	 */
	@Bean(name = "securityManager")
	public SecurityManager securityManager(DefaultWebSessionManager defaultWebSessionManager, RedisCacheManager redisCacheManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm());
		securityManager.setSessionManager(defaultWebSessionManager);
		securityManager.setCacheManager(redisCacheManager);
		return securityManager;
	}

	/**
	 * DefaultAdvisorAutoProxyCreator，Spring的一个bean， 由Advisor决定对哪些类的方法进行AOP代理。
	 *
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}

	/**
	 * AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
	 * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
	 * 老实说，这里注入securityManager，我不知道有啥用，从source上看不出它在什么地方会被调用。
	 *
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor attributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager);
		return aasa;
	}

	/**
	 * ShiroDialect，为了在thymeleaf里使用shiro的标签的bean
	 * <groupId>com.github.theborakompanioni</groupId>
	 * <artifactId>thymeleaf-extras-shiro</artifactId> <version>1.2.1</version>
	 *
	 * @return
	 */
	// @Bean(name = "shiroDialect")
	// public ShiroDialect shiroDialect() {
	// return new ShiroDialect();
	// }


}
