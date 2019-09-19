package com.study.cloud.microserviceprovideruser.repositor.impl;

import com.study.cloud.microserviceprovideruser.entity.User;
import com.study.cloud.microserviceprovideruser.repositor.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserRepositoryImpl implements UserRepository {
    @Override
    public User findById(Long id) {
        User user=new User();
        user.setUsername("user1");
        user.setName("王帆");
        user.setAge((short) 26L);
        user.setBalance(new BigDecimal(100.00));
        return user;
    }
}
