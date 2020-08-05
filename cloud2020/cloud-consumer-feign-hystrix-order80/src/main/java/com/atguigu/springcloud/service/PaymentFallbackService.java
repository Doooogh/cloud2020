package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author li long
 * @Date 2020/8/5 15:24
 * @Version 1.0
 **/
@Service
public class PaymentFallbackService implements PaymentHystirxService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService_ fall back_paymentInfo_OK error";
    }

    @Override
    public String payementInfo_TIMEOUT(Integer id) {
        return "PaymentFallbackService_ fall back_payementInfo_TIMEOUT error";

    }
}
