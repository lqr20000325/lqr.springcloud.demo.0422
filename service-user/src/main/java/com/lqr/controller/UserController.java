package com.lqr.controller;

import com.lqr.entity.User;
import com.lqr.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id  获取名称
     */
    @RequestMapping("getUserById")
    public User getUserById(@RequestParam("id")Integer id) throws InterruptedException {
        log.info("userId:{}",id);
       // Thread.sleep(1000);
        //超时直接打断点
        return userService.getUserById(id);
    }

    @RequestMapping("getUserByUser")
    public User getUserById(@RequestBody User user){
        log.info("userId:{}",user.getId());
        return userService.getUserById(user.getId());
    }

    /**
     * 根据id  获取用户名称
     */
    @RequestMapping("getUsernameById")
    public String getUsernameById(@RequestParam("id")Integer id){
        return userService.getUsernameById(id);
    }
}
