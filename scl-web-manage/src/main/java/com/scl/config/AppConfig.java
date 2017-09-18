package com.scl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * Created by shengchenglong on 17/2/28.
 */
@Configuration
@ImportResource("classpath:META-INF/spring/*.xml")
public class AppConfig {

    // 配置freemakerfactorybean
    @Bean
    public FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean(){
        FreeMarkerConfigurationFactoryBean configurationFactoryBean = new FreeMarkerConfigurationFactoryBean();
        configurationFactoryBean.setTemplateLoaderPaths(new  String[]{"/WEB-INF/ftl"});
        configurationFactoryBean.setDefaultEncoding("UTF-8");
        return configurationFactoryBean;
    }

}
