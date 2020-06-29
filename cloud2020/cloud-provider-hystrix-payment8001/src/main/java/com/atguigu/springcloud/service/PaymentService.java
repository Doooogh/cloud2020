package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author li long
 * @Date 2020/6/29 0:41
 * @Version 1.0
 **/
@Service
public class PaymentService {


    /**
     * @Author li long
     * @Description --正常访问 肯定是没有问题的
     * @Date 2020/6/29 0:43
     * @Param [id]
     * @return java.lang.String
     **/
    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+"  paymentInof_OK,id:"+id;
    }


    public String paymentInfo_TIMEOUT(Integer id){
        int timeNumber=3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"  paymentInof_TIMEOUT,耗时"+timeNumber+"秒钟";
    }

}
