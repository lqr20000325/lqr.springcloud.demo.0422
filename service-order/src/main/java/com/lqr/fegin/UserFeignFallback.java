package com.lqr.fegin;

import com.lqr.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserFeignFallback implements UserFeignClient{


    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setUsername("id:错误值：fallback");
        return user;
    }

    @Override
    public User getUserByUser(User user) {
        User u = new User();
        u.setUsername("user:错误值：fallback");
        return u;
    }

    @Override
    public String getUsernameById(Integer id) {
        return null;
    }
}
