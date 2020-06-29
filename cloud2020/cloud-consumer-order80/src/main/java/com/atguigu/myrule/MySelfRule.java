package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description  自定义负载均衡规则
 * @Author li long
 * @Date 2020/6/27 23:38
 * @Version 1.0
 **/
@Configuration
public class MySelfRule {

    /*
     * com.netflix.loadbalancer.RoundRobinRule  轮询 默认的
        com.netflix.loadbalancer.RandomRule  随机
        com.netflix.loadbalancer.RetryRule  先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试
        WeightedResponseTimeRule   对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择
        BestAvailableRule   会先过滤掉由于多次访问故障(比如熔断机制)而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
        AvailabilityFilteringRule  先过滤掉故障实例，再选择并发较小的实例
        ZoneAvoidanceRule  默认规则，复合判断server所在区域的性能和server的可用性选择服务器
     **/

    @Bean
    public IRule myRule(){  //方法名不能跟类名相同
        return new RoundRobinRule();  //规则定义为随机
    }
}
