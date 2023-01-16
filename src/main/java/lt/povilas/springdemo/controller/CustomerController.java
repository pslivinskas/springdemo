package lt.povilas.springdemo.controller;

import lt.povilas.springdemo.repository.model.Customer;
import lt.povilas.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/customermapping")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage() {
        return "This is some test from Spring";
    }

    // http://localhost:8080/customermapping/customer/all
    // 1. url base = http://localhost:8080/customermapping
    // 2. url extension = /customer/all
    @GetMapping(path = "/customer/all")
    public @ResponseBody List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // http://localhost:8080/customermapping/customer/112
    @GetMapping(path = "/customer/{id}")
    public @ResponseBody Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }
}
