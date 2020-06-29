package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author li long
 * @Date 2020/6/29 0:13
 * @Version 1.0
 **/
@Configuration
public class FeignConfig {





    /**
     * @Author li long
     * @Description --配置openFeign自带的日志监控 级别
     * @Date 2020/6/29 0:14
     * @Param []
     * @return feign.Logger.Level
     **/
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;   //这里设置为full  一个请求所有的信息 包括请求头 响应体  不是日志的级别   error warm  info  debug
    }
}
