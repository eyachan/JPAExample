package com.eya.jpaexample.controller;

import com.eya.jpaexample.dto.OrderRequest;
import com.eya.jpaexample.model.Customer;
import com.eya.jpaexample.repository.CustomerRepository;
import com.eya.jpaexample.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public OrderController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest orderRequest) {
        return customerRepository.save(orderRequest.getCustomer());
    }

    @GetMapping("/findAllOrder")
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

}
