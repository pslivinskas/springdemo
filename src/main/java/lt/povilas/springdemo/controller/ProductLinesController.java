package lt.povilas.springdemo.controller;

import lt.povilas.springdemo.repository.model.Customer;
import lt.povilas.springdemo.repository.model.ProductLines;
import lt.povilas.springdemo.service.CustomerService;
import lt.povilas.springdemo.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/productlinemapping")
public class ProductLinesController {
    @Autowired
    private ProductLineService productLineService;

    @GetMapping(path = "/test")
    public @ResponseBody String getTestPage() {
        return "This is some test from Spring";
    }

    @GetMapping(path = "/productline/all")
    public @ResponseBody List<ProductLines> getAllProductLines() {
        return productLineService.getAllProductLines();
    }

    @GetMapping(path = "/productline/{id}")
    public @ResponseBody ProductLines getProductLineById(@PathVariable String id) {
        return productLineService.getProductLineById(id);
    }
}
