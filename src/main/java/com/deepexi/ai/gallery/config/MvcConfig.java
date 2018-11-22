package com.deepexi.ai.gallery.config;

import com.deepexi.ai.gallery.interceptor.Intercecptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/video_back/upload").setViewName("upload");
//        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/upload_success").setViewName("uploadMsg");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new Intercecptor()).addPathPatterns("/video_back/**")
//                .excludePathPatterns("/","/login/**","/video_back/play");
        registry.addInterceptor(new Intercecptor()).addPathPatterns("/upload");
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/"); }



}
