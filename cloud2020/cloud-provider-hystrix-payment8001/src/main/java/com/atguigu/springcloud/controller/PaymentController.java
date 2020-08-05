package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author li long
 * @Date 2020/6/29 0:45
 * @Version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;



    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String info_ok = paymentService.paymentInfo_OK(id);
        log.info("*******infoOk  result:"+info_ok);
        return info_ok;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payementInfo_TIMEOUT(@PathVariable("id") Integer id){

        String infoTimeout = paymentService.paymentInfo_TIMEOUT(id);
        log.info("***********timeout result:"+infoTimeout);
        return infoTimeout;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }


}
