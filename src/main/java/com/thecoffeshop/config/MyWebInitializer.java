package com.thecoffeshop.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                PersistenceJPAConfig.class, SecurityApplicationInitializer.class,
                WebSecurityConfig.class, WebSecurityShipperConfig.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                SpringWebConfig.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
