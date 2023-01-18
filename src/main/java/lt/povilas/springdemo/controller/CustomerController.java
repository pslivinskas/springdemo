package lt.povilas.springdemo.controller;

import lt.povilas.springdemo.repository.model.Customer;
import lt.povilas.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // http://localhost:8080/customermapping/mycustomer/112
    @GetMapping(path = "/mycustomer/{id}")
    public @ResponseBody Customer getMyCustomerById(@PathVariable int id) {
        return customerService.getMyCustomerById(id);
    }

    // http://localhost:8080/customermapping/mycustomer/name/Diecast%20Collectables
    @GetMapping(path = "/mycustomer/name/{name}")
    public @ResponseBody Customer getMyCustomerByName(@PathVariable String name) {
        return customerService.getMyCustomerByName(name);
    }

    // http://localhost:8080/customermapping/mycustomer/like/a
    @GetMapping(path = "/mycustomer/like/{name}")
    public @ResponseBody List<Customer> getMyCustomerByNameLike(@PathVariable String name) {
        return customerService.getMyCustomerByNameLike("%" + name + "%");
    }

    // http://localhost:8080/customermapping/mycustomer/querylike/auto
    @GetMapping(path = "/mycustomer/querylike/{name}")
    public @ResponseBody List<Customer> getQueryCustomerByNameLike(@PathVariable String name) {
        return customerService.getQueryCustomerByNameLike("%" + name + "%");
    }

    // http://localhost:8080/customermapping/mycustomer/id?customerNumber=112
    @GetMapping(path = "/mycustomer/id")
    public @ResponseBody Customer getMyCustomerByIdWithRequestParam(@RequestParam int customerNumber) {
        return customerService.getMyCustomerById(customerNumber);
    }

  }
