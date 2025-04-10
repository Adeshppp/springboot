package com.reactiveprogramming.webflux.service;


import com.reactiveprogramming.webflux.dao.CustomerDao;
import com.reactiveprogramming.webflux.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> loadAllCustomer(){
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomer();
        long end = System.currentTimeMillis();
        System.out.println("total execution time : "+ (end-start));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream(){
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("total execution time : "+ (end-start));
        return customers;
    }
}
