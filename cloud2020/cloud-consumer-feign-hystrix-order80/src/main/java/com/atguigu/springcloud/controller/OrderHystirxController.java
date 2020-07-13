package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderHystirxService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author li long
 * @Date 2020/7/13 12:41
 * @Version 1.0
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //统一配置服务降级
public class OrderHystirxController {

    @Resource
    private OrderHystirxService orderHystirxService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
      String result=  orderHystirxService.paymentInfo_OK(id);
        log.info("*******result:"+result);
        return result;
    }


   /* @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500"),  //请求超时 或者服务错误
           *//* @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸*//*
    })*/
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payementInfo_TIMEOUT(@PathVariable("id") Integer id){
        int a=10/0;
        String result=  orderHystirxService.payementInfo_TIMEOUT(id);
        log.info("*******result:"+result);
        return result;
    }

  //配置单个接口的降级处理时 接口的参数一定要对应上  需要一样
    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "单个接口异常处理，系统繁忙请稍后重试，失败==----";

    }
    //全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "全局异常处理，系统繁忙请稍后重试，失败==----";

    }
}
