package com.lqr.controller;

import com.lqr.entity.User;
import com.lqr.fegin.UserFeignClient;
import com.lqr.model.Order;
import com.lqr.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    /**
     * 根据id，查询订单
     */
    @RequestMapping("/getOrderById")
    @HystrixCommand(fallbackMethod = "getOrderByIdFallback")
    public Order getOrderById(@RequestParam("id") Integer id){
        Order order = orderService.getOrderById(id);

        //service-user是被调用服务名称，spring.application.name的名称

        //User user = restTemplate.getForObject("http://service-user/user/getUserById?id="+order.getUserid(), User.class);

        //order.setUserid(user.getId());
        //order.setUsername(user.getUsername());

        User user2 = new User();
        user2.setId(1);
        User userByUser = userFeignClient.getUserByUser(user2);
        order.setUsername(userByUser.getUsername());
        return order;
    }

    /**
     * getOrderByIdFallback方法参数要和getOrderById参数一致。
     * @param id
     * @return
     */
    public Order getOrderByIdFallback(Integer id){
        Order order = orderService.getOrderById(id);
        order.setUsername("固定值");
        return order;
    }
}
