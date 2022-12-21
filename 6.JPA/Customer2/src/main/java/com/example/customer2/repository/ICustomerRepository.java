package com.example.customer2.repository;

import com.example.customer2.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
