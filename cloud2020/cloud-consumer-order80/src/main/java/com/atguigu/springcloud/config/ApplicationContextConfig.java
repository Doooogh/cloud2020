package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author li long
 * @Date 2020/6/23 0:40
 * @Version 1.0
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //负载均衡 自动配置  默认是轮询机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
