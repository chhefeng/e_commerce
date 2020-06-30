package com.hef.controller;

import com.hef.entity.CustomerOrder;
import com.hef.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<CustomerOrder> getOrder(){
        return orderService.findAll();
    }

    @GetMapping("/order/{orderId}")
    public CustomerOrder getOrderById (@PathVariable("orderId") Long orderId){
        return orderService.findById(orderId);
    }

    @PostMapping("/order")
    public CustomerOrder postOrder(@RequestBody CustomerOrder customerOrder){
        return orderService.save(customerOrder);
    }


}
