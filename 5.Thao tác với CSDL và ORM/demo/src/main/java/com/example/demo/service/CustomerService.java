package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.Collections;
import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer save(Customer customer);
    Customer findById(long id);
    List<Customer> save(List<Customer> customer);
    boolean exists(Long id);
    List<Customer> findAll(List<Long> ids);
    long count();
    void delete(Long id);
    void delete(Customer customer);
    void delete(List<Customer> customers);
    void deleteAll();


}
