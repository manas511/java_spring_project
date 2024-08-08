package com.example.demo.usermanagement.service;


import com.example.demo.usermanagement.model.Customer;
import com.example.demo.usermanagement.model.ServiceProvider;
import com.example.demo.usermanagement.repository.CustomerRepository;
import com.example.demo.usermanagement.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public ServiceProvider saveServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    public Optional<Customer> findCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public Optional<ServiceProvider> findServiceProviderByUsername(String username) {
        return serviceProviderRepository.findByUsername(username);
    }
}
