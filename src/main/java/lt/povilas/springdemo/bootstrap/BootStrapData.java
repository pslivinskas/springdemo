package lt.povilas.springdemo.bootstrap;

import lt.povilas.springdemo.repository.CustomerRepository;
import lt.povilas.springdemo.repository.ProductLinesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductLinesRepository productLinesRepository;

    @Override
    public void run(String... args) throws Exception {

        customerRepository.findAll().forEach(System.out::println);
        System.out.println("\n=================\n");
        System.out.println(customerRepository.findById(112));
        System.out.println("\n=================\n");
        productLinesRepository.findAll().forEach(System.out::println);
        System.out.println(productLinesRepository.findById("Ships"));

    }
}
