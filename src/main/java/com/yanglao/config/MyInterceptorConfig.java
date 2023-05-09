package com.yanglao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: LaoAyu
 * @date: 2023/03/10
 **/

//注册拦截器
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    /**
     * 静态资源映射
     * 访问静态资源路径：http://localhost:9999/pic/1.jpg
     * 映射到本地磁盘上的：D:/ParkingManagementSystem/Parking/pic/1.jpg
     * 可以添加多个映射，多个磁盘位置都可用 http://localhost:9999/pic/** 访问到本地此磁盘文件
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pic/**")
                .addResourceLocations("file:D:/学习/课设/pic/");
    }
}
