package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.model.Department;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
    private static final Map<Integer, Customer> customers;
    private static final Map<Integer, Department> departmentList;

    static {
        customers = new HashMap<>();
        departmentList = new HashMap<>();
        departmentList.put(1,new Department(1,"Kinh doanh"));
        departmentList.put(2,new Department(2,"Nhan su"));
        departmentList.put(3,new Department(3,"Ke toan"));

        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi",departmentList.get(1)));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang",departmentList.get(2)));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon",departmentList.get(3)));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin",departmentList.get(1)));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami",departmentList.get(2)));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork",departmentList.get(3)));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public List<Department> findAllDepartment() {
        return new ArrayList<>(departmentList.values()) ;
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }


    public Department findByIdDepartment(int id) {
        return departmentList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }

    @Override
    public List<Customer> findByName(String nameSearch) {

        List<Customer> customerList = new ArrayList<>();
        for (Customer customer: findAll()) {
            if (customer.getName().toLowerCase().contains(nameSearch)){
                customerList.add(customer);
            }
        }
        return  customerList;
    }


}
