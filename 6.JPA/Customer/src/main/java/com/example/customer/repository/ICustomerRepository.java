package com.example.customer.repository;

import com.example.customer.model.Customer;
import com.example.customer.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByProvince(Province province);
    Iterable<Customer> findAll(Sort sort);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
