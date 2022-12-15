package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.model.Department;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    List<Department> findAllDepartment();

    void save(Customer customer);

    Customer findById(int id);
    Department findByIdDepartment(int id);

    void update(int id, Customer customer);

    void remove(int id);

    List<Customer> findByName(String nameSearch);
}
