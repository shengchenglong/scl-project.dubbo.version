package com.scl.shiro.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by shengchenglong on 17/3/6.
 */
@ConfigurationProperties(prefix = "redis.config")
public class RedisConfigProperties {

    private int expire;
    private String host;
    private String password;
    private int port;

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
