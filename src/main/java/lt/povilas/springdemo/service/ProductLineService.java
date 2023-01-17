package lt.povilas.springdemo.service;

import lt.povilas.springdemo.repository.ProductLinesRepository;
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

    public ProductLines getProductLineByName(String productLineName) {
        return productLinesRepository.findByProductLine(productLineName).get();
    }

    public List<ProductLines> getProductLineByNameLike(String productLineName) {
        return (List<ProductLines>) productLinesRepository.findByProductLineLike(productLineName);
    }

}