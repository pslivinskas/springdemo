package lt.povilas.springdemo.service;

import lt.povilas.springdemo.repository.CustomerRepository;
import lt.povilas.springdemo.repository.ProductLinesRepository;
import lt.povilas.springdemo.repository.model.Customer;
import lt.povilas.springdemo.repository.model.ProductLines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineService {
    @Autowired
    private ProductLinesRepository productLinesRepository;

    public List<ProductLines> getAllProductLines() {
        return (List<ProductLines>) productLinesRepository.findAll();
    }

    public ProductLines getProductLineById(String productLinesId){
        return (ProductLines) productLinesRepository.findById(productLinesId).get();

    }


}