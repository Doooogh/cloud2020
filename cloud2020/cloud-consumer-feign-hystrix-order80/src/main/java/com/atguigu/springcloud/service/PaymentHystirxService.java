package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)
public interface PaymentHystirxService {

    //不适用restTemplate了  通过内部的rpc调用  使用这个接口 相当于调用 CLOUD-PROVIDER-HYSTRIX-PAYMENT服务下的  接口
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);



    @GetMapping("/payment/hystrix/timeout/{id}")
    public String payementInfo_TIMEOUT(@PathVariable("id") Integer id);





}
