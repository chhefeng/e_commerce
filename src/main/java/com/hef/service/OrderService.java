package com.hef.service;

import com.hef.entity.CustomerOrder;
import javassist.NotFoundException;

import java.util.List;

public interface OrderService {

    public List<CustomerOrder> findAll();

    public CustomerOrder findById(Long id);

    public CustomerOrder save(CustomerOrder customerOrder);

    CustomerOrder updateOrder(CustomerOrder customerOrder, Long id) throws NotFoundException;

    public void deleteById(Long id);


}
