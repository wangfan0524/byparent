package com.study.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoadBalanceConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule iRule(){
        //默认轮询策略
        //return new RoundRobinRule();
        //重试策略，默认失败三次，停止访问
        //return new RetryRule();
        //随机策略
        //return new RandomRule();
        //自定义策略
        return new MyRibbonConfigRule();
    }
}
