package com.example.OrderCustomer.Service.impl;

import com.example.OrderCustomer.Model.CustomerModel;
import com.example.OrderCustomer.Repository.CustomerRepository;
import com.example.OrderCustomer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerModel createCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerModel> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerModel getCustomer(Long id) {
        Optional<CustomerModel> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;
    }

    @Override
    public CustomerModel updateCustomer(Long id, CustomerModel customer) {
        Optional<CustomerModel> resultCustomer = customerRepository.findById(id);
        if (resultCustomer.isPresent()) {
            resultCustomer.get().setName(customer.getName());
            resultCustomer.get().setAge(customer.getAge());
            resultCustomer.get().setOrders(customer.getOrders());
            return customerRepository.save(resultCustomer.get());
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Optional<CustomerModel> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
