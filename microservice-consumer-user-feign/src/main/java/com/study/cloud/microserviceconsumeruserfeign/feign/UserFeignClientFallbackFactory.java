package com.study.cloud.microserviceconsumeruserfeign.feign;

import com.study.cloud.microserviceconsumeruserfeign.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                User user=new User();
                user.setName("服务端宕机了");
                return user;
            }

            @Override
            public User submit(User user) {
                return null;
            }
        };
    }
}
