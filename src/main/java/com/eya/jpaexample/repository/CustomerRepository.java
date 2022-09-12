package com.eya.jpaexample.repository;

import com.eya.jpaexample.dto.OrderResponse;
import com.eya.jpaexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select new com.eya.jpaexample.dto.OrderResponse(c.name , p.productName) from Customer c join c.products p ")
    public List<OrderResponse> getJoiningInformation();
}
