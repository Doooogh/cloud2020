package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/13 12:36
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix  //开启服务降级
public class OrderHystirxMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystirxMain80.class,args);
    }
}
