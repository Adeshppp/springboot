package com.reactiveprogramming.webflux.controller;


import com.reactiveprogramming.webflux.dto.Customer;
import com.reactiveprogramming.webflux.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCostumers(){
        return customerService.loadAllCustomer();
    }
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCostumersStream(){
        return customerService.loadAllCustomersStream();
    }
}
