package com.study.cloud.microserviceconsumeruserfeign.feign;

import com.study.cloud.microserviceconsumeruserfeign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Impl implements UserFeignClient {
    @Autowired
    private UserFeignClient userFeignClient;
    @Override
    public User findById(Long id) {
        return userFeignClient.findById(id);
    }

    @Override
    public User submit(User user) {
        return null;
    }
}
