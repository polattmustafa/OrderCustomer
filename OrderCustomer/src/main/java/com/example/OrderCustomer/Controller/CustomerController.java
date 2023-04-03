package com.example.OrderCustomer.Controller;

import com.example.OrderCustomer.Model.CustomerModel;
import com.example.OrderCustomer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel customer) {
        CustomerModel resultCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(resultCustomer);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CustomerModel>> getCustomers() {
        List<CustomerModel> customers = customerService.getCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CustomerModel> getCustomer(@PathVariable("id") Long id) {
        CustomerModel customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CustomerModel> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerModel customer) {
        CustomerModel resultCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(resultCustomer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") Long id) {
        boolean status = customerService.deleteCustomer(id);
        return ResponseEntity.ok(status);
    }

}
