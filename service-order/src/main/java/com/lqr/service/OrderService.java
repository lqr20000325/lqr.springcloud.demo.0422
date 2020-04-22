package com.lqr.service;

import com.lqr.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    /**
     *根据id，查询订单
     */
    public Order getOrderById(Integer id){
        Order order = new Order();

        order.setId(id);
        order.setOrderno(System.currentTimeMillis()+"");

        return order;
    }

}
