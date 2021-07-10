package com.qgzx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author yanni
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOriginPatterns("*") // 所有的外部域都可跨域访问。 如果是localhost则很难配置，因为在跨域请求的时候，外部域的解析可能是localhost、127.0.0.1、主机名
                        .allowCredentials(true) // 是否支持跨域用户凭证
                        .allowedMethods("*") // 当前站点支持的跨域请求类型是什么
                        .maxAge(3600); // 超时时长设置为1小时。 时间单位是秒。
            }
        };
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加跨域
        //registry.addInterceptor(interceptorCORS).addPathPatterns("/**");
    }


}