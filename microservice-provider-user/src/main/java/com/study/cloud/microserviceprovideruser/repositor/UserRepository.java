package com.study.cloud.microserviceprovideruser.repositor;

import com.study.cloud.microserviceprovideruser.entity.User;



public interface UserRepository  {
    User findById(Long id);
}
