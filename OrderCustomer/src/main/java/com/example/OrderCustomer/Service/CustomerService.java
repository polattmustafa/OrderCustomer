package com.example.OrderCustomer.Service;

import com.example.OrderCustomer.Model.CustomerModel;

import java.util.List;

public interface CustomerService {

    CustomerModel createCustomer(CustomerModel customer);

    List<CustomerModel> getCustomers();

    CustomerModel getCustomer(Long id);

    CustomerModel updateCustomer(Long id, CustomerModel customer);

    boolean deleteCustomer(Long id);
}
