package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @Description
 * @Author li long
 * @Date 2020/6/23 0:05
 * @Version 1.0
 **/
public interface PaymentService {
    public int create(Payment payment); //写

    public Payment getPaymentById(Long id);  //读取
}
