package com.study.cloud.microserviceconsumeruserfeign.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.cloud.microserviceconsumeruserfeign.entity.User;
import com.study.cloud.microserviceconsumeruserfeign.feign.EurekaFeignClient;
import com.study.cloud.microserviceconsumeruserfeign.feign.UserFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "测试接口")
@RestController
public class MovieFeignController {

    @Autowired
    private EurekaFeignClient eurekaFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/movie/get/{id}")
    @HystrixCommand
    @ApiOperation(value = "用户列表", notes = "用户列表")
    public Object getMovie(@PathVariable Long id) {
        Object object = userFeignClient.findById(id);
        return object;
    }

    @GetMapping("/testPost")
    @HystrixCommand
    @ApiOperation(value = "创建用户", notes = "创建用户")
    public User getUser(User user) {
        return this.userFeignClient.submit(user);
    }

    @RequestMapping(value = "/testPost1", method = RequestMethod.POST)
    public String getUser1(@RequestBody List<JSONObject> jsonObjectList) {
        System.out.println(jsonObjectList);
        User user1 = new User();
        user1.setName("王");
        return user1.toString();
    }

    @GetMapping("/getserviceInfo/{serviceName}")
    public String getUser(@PathVariable String serviceName) {
        return this.eurekaFeignClient.findServiceInfoByServiceName(serviceName);
    }
}
