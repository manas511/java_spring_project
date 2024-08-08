package com.example.demo.usermanagement.controller;

import com.example.demo.usermanagement.model.Customer;
import com.example.demo.usermanagement.model.ServiceProvider;
import com.example.demo.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register/customer")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = userService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PostMapping("/register/service-provider")
    public ResponseEntity<ServiceProvider> registerServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        ServiceProvider savedServiceProvider = userService.saveServiceProvider(serviceProvider);
        return ResponseEntity.ok(savedServiceProvider);
    }

    @PostMapping("/login/customer")
    public ResponseEntity<String> loginCustomer(@RequestBody Customer customer) {
        return userService.findCustomerByUsername(customer.getUsername())
                .map(user -> user.getPassword().equals(customer.getPassword()) ?
                        ResponseEntity.ok("Successfully logged in") :
                        ResponseEntity.status(401).body("Wrong password"))
                .orElse(ResponseEntity.status(404).body("User not available"));
    }

    @PostMapping("/login/service-provider")
    public ResponseEntity<String> loginServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        return userService.findServiceProviderByUsername(serviceProvider.getUsername())
                .map(user -> user.getPassword().equals(serviceProvider.getPassword()) ?
                        ResponseEntity.ok("Successfully logged in") :
                        ResponseEntity.status(401).body("Wrong password"))
                .orElse(ResponseEntity.status(404).body("User not available"));
    }
}