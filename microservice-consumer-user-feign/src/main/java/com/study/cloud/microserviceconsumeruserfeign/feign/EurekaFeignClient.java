package com.study.cloud.microserviceconsumeruserfeign.feign;

import com.study.cloud.config.FeignConfiguration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "xxxx",url = "http://localhost:8761/",configuration = FeignConfiguration2.class)
public interface EurekaFeignClient {

    @RequestMapping(value = "eureka/apps/{serviceName}")
    public String findServiceInfoByServiceName(@PathVariable("serviceName") String serviceName);

}
