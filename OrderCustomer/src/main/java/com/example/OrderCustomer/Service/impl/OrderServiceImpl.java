package com.example.OrderCustomer.Service.impl;

import com.example.OrderCustomer.Model.CustomerModel;
import com.example.OrderCustomer.Model.OrderModel;
import com.example.OrderCustomer.Repository.OrderRepository;
import com.example.OrderCustomer.Service.CustomerService;
import com.example.OrderCustomer.Service.OrderService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public boolean createOrder(OrderModel orderModel, Long customer_id) {
        try {
            CustomerModel customer = customerService.getCustomer(customer_id);
            orderModel.setCreateDate(new Date());
            orderModel.setCustomers(customer);
            orderRepository.save(orderModel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public OrderModel getOrder(long order_id) {
        return orderRepository.getById(Long.valueOf(order_id));
    }

    @Override
    public OrderModel updateOrder(OrderModel orderModel, long id) {
        Optional<OrderModel> resultOrder = orderRepository.findById(Long.valueOf(id));
        if (resultOrder.isPresent()) {
            resultOrder.get().setTotalPrice(orderModel.getTotalPrice());
            return orderRepository.save(resultOrder.get());
        }
        return null;
    }

    @Override
    public boolean deleteOrder(Long id) {
        Optional<OrderModel> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
