package com.fans.farm.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 配置跨域请求
 * Created by Administrator on 2017/3/4
 */
@Configuration
@ComponentScan(basePackageClasses = { WebMvcConfig.class })
public class WebMvcConfig extends  WebMvcConfigurationSupport {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    //添加映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/mp").addResourceLocations("classpath:/mp");
        registry.addResourceHandler("/.well-known/pki-validation/**").addResourceLocations("classpath:/well-known/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
