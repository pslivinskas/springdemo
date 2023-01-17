package lt.povilas.springdemo.controller;

import lt.povilas.springdemo.repository.model.Customer;
import lt.povilas.springdemo.repository.model.ProductLines;
import lt.povilas.springdemo.service.CustomerService;
import lt.povilas.springdemo.service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    // http://localhost:8080/productlinemapping/productline/name/Ships
    @GetMapping(path = "/productline/name/{name}")
    public @ResponseBody ProductLines getProductLineByName(@PathVariable String name) {
        return productLineService.getProductLineByName(name);
    }

    // http://localhost:8080/productlinemapping/productline/like/cars
    @GetMapping(path = "/productline/like/{name}")
    public @ResponseBody List<ProductLines> getMyProductLineByNameLike(@PathVariable String name) {
        return productLineService.getProductLineByNameLike("%" + name + "%");
    }
}
