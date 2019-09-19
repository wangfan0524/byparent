package com.study.cloud.microserviceprovideruser.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.cloud.microserviceprovideruser.entity.User;
import com.study.cloud.microserviceprovideruser.repositor.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EurekaClient eurekaClient;
    @GetMapping("/simple/{id}")
    @HystrixCommand(fallbackMethod = "fall")
    public User findById(@PathVariable Long id) throws MalformedObjectNameException {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String port = objectNames.iterator().next().getKeyProperty("port");
        System.out.println(port);
        if (id==2){
            throw new RuntimeException("没有查到结果");
        }
        return userRepository.findById(id);
    }
    public User fall(@PathVariable Long id) {
        //使用VIP vitrual IP(服务提供者的serviceID 或者spring.application.name)
        String string = "服务挂掉了，我是fallbackMethod";
        User user=new User();
        user.setName(string);
        return user;
    }
    @GetMapping("/eureka-instance")
    public String serviceUrl(){;
        InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("PROVIDER-USER",false);
        return instanceInfo.getHomePageUrl();
    }
    @PostMapping("/user")
    User submit(@RequestBody User user){
        return user;
    }
}
