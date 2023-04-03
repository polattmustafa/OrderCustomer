package com.example.OrderCustomer.Service;

import com.example.OrderCustomer.Model.OrderModel;

public interface OrderService {

    boolean createOrder(OrderModel orderModel, Long customer_id);

    OrderModel getOrder(long order_id);

    OrderModel updateOrder(OrderModel orderModel, long id);

    boolean deleteOrder(Long id);
}
