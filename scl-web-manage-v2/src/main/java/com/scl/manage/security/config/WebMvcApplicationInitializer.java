package com.scl.manage.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.thymeleaf.spring4.view.ThymeleafView;

/**
 * @author shengchenglong
 * @version 1.0
 * @since 17/9/19 14:56 JDK 1.8
 */
public class WebMvcApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebSecurityConfig.class};
    }

    /**
     * 得到controler和ViewResolver的配置
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ThymeleafView.class};
    }

    /**
     * 标识哪些url要经过这个DisptacherServlet处理
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
