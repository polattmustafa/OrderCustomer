package com.example.OrderCustomer.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @OneToMany (mappedBy = "customers", fetch = FetchType.LAZY)
    private List<OrderModel> orders;

}
