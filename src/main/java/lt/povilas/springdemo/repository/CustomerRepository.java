package lt.povilas.springdemo.repository;

import lt.povilas.springdemo.repository.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer, Integer> {

}
