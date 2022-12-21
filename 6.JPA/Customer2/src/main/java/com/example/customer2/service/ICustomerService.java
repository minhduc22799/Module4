package com.example.customer2.service;

import com.example.customer2.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);

}
