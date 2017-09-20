package com.scl.manage.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * @author shengchenglong
 * @version 1.0
 * @since 17/9/19 15:34 JDK 1.8
 */
@Configuration
public class WebMvcConfig {

    /**
     * 将thymeleaf的排版布局方言 整合到 Spring模板引擎
     *
     * @return
     */
    @Bean
    public SpringTemplateEngine springTemplateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect());
        return engine;
    }
}
