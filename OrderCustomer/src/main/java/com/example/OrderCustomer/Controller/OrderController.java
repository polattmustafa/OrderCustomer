package com.example.OrderCustomer.Controller;

import com.example.OrderCustomer.Model.CustomerModel;
import com.example.OrderCustomer.Model.OrderModel;
import com.example.OrderCustomer.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create/{customer_id}")
    public String createOrder(@RequestBody OrderModel orderModel, @PathVariable("customer_id") Long customer_id) {
        boolean isAddedOrder = orderService.createOrder(orderModel, customer_id);
        if (isAddedOrder)
            return "added Order";
        else
            return "could not added Order!";
    }

    @GetMapping("/get/{order_id}")
    public OrderModel getOrder(@PathVariable("order_id") long order_id) {
        return orderService.getOrder(order_id);
    }

    public ResponseEntity<OrderModel> updateOrder(@RequestBody OrderModel orderModel, @PathVariable("id") Long id) {
        OrderModel resultOrder = orderService.updateOrder(orderModel, id);
        return ResponseEntity.ok(resultOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteOrder(@PathVariable("id") Long id) {
        boolean status = orderService.deleteOrder(id);
        return ResponseEntity.ok(status);
    }

}
