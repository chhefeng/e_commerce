package com.hef.service.impl;

import com.hef.dao.OrderRepository;
import com.hef.entity.CustomerOrder;
import com.hef.service.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<CustomerOrder> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public CustomerOrder findById(Long id) {
        return orderRepository.getOne(id);
    }

    @Transactional
    @Override
    public CustomerOrder save(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    @Override
    public CustomerOrder updateOrder(CustomerOrder customerOrder, Long id) throws NotFoundException {
        CustomerOrder customerOrder1 = orderRepository.getOne(id);
        if (customerOrder == null) {
            throw new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(customerOrder, customerOrder1);
        return orderRepository.save(customerOrder);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<CustomerOrder> findAllByCustomerId(Long customerId) {
        return null;
    }
}
