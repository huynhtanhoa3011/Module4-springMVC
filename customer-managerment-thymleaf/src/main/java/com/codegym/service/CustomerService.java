package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService{
    private static final Map<Integer, Customer> customers;
    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Hoa", "hoa@gmail.com", "Hue"));
        customers.put(2, new Customer(2, "Hoang", "hoang@gmail.com", "Sai Gon"));
        customers.put(3, new Customer(3, "Binh", "binh@gmail.com", "Quang Binh"));
        customers.put(4, new Customer(4, "Chuong", "chuong@gmail.com", "Da Nang"));
        customers.put(5, new Customer(5, "Phuong", "phuong@gmail.com", "Nghe An"));
        customers.put(6, new Customer(6, "Nhi", "nhi@gmail.com", "Quang Tri"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);

    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);

    }

    @Override
    public void remove(int id) {
        customers.remove(id);

    }
}
