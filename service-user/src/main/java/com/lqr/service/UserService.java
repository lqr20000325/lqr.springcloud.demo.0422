package com.lqr.service;

import com.lqr.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * 根据id  获取名称
     */
    public User getUserById(Integer id){
        User user = new User();

        user.setId(id);
        user.setUsername("username:"+id);
        return user;
    }

    /**
     * 根据id  获取用户名称
     */
    public String getUsernameById(Integer id){
        User user = new User();
        user.setId(id);
        return user.getUsername();
    }
}
