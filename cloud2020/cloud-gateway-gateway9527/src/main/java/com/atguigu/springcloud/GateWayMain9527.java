package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/5 18:29
 * @Version 1.0
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 获取EureKa中的服务信息
public class GateWayMain9527 {

    public static void main(String[] args) {
        SpringApplication.run( GateWayMain9527.class,args);
    }
}
