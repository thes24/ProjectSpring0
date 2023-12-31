package com.example.Project0.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.Project0.interceptor.MemberInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MemberInterceptor logInInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(logInInterceptor)
                .excludePathPatterns("/api/member/signup")
                .excludePathPatterns("/api/member/login")
                .excludePathPatterns("/api/member/check-login")
                .excludePathPatterns("/api/member/check-email")
                .addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                    .allowedOrigins("http://localhost:3000")
                    .allowedOrigins("http://s.yeon-tae-woo.kro.kr/")
                    .allowedHeaders("*")
                    .allowedMethods("*")
                    .allowCredentials(true)
                    .maxAge(3600);
    }
}
