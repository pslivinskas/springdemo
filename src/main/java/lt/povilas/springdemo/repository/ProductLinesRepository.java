package lt.povilas.springdemo.repository;

import lt.povilas.springdemo.repository.model.ProductLines;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductLinesRepository extends CrudRepository <ProductLines, String> {
}
