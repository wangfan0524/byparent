package com.study.cloud.microserviceconsumeruserfeign.feign;

import com.study.cloud.config.FeignConfiguration;
import com.study.cloud.microserviceconsumeruserfeign.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

// 指定当前FeignClient所绑定的提供者微服务名称,以及降级处理类
@FeignClient(name = "microservice-provider-user",fallbackFactory = UserFeignClientFallbackFactory.class,configuration = FeignConfiguration.class)
public interface UserFeignClient {
    //使用Feign的时候,如果参数中带有@PathVariable形式的参数,
    // 则要用value=""标明对应的参数,否则会抛出IllegalStateException异常
    @RequestLine("GET /simple/{id}")
    User findById(@Param(value = "id") Long id);

    //@PostMapping("/user")
    @RequestLine("POST /user")
    User submit(@RequestBody User user);
}
